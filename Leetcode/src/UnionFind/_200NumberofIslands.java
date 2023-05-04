package unionFind;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: mianmiantea2019
 * @Date: 2023-05-03 7:15 PM
 * @LastEditors: mianmiantea2019
 * @Description:
 */


public class _200NumberofIslands {

  public int numIslands(char[][] grid) {
        // row col
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(i, j, grid, row, col);
                }
            }
        }
        return count;
    }

    private void dfs(int x, int y, char[][] grid, int row, int col){
        if(x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == '0'){
            return;
        }

        grid[x][y] = '0';

        dfs(x+1, y, grid, row, col);
        dfs(x-1, y, grid, row, col);
        dfs(x, y+1, grid, row, col);
        dfs(x, y-1, grid, row, col);
    }

    //BFS
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    public int numIslands2(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] v = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    count++;
                    bfs(i,j,grid,row,col,q,v);
                }
            }
        }
        return count;
    }

    private void bfs(int x, int y, char[][] grid, int row, int col, Queue<int[]> q, boolean[][] v){
        q.add(new int[]{x, y});
        grid[x][y] = '0';
        v[x][y] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int k=0; k<4;k++){
                int nx = cx+dx[k];
                int ny = cy+dy[k];
                if(nx >= 0 && ny >= 0 && nx<row && ny<col&&grid[nx][ny]=='1'&&!v[nx][ny]){
                    grid[nx][ny] = '0';
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return;
    }

    // Union Find
    public int numIslands3(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        // all cells - water - union numbers
        int water = 0;
        UF uf = new UF(grid);

        for(int x = 0; x < row; x++){
            for(int y = 0; y < col; y++){
                if(grid[x][y] == '0'){
                    water++;
                }else{
                    for(int i = 0; i < 4; i++){
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        if(nx >= 0 && ny >= 0 && nx < row && ny < col && grid[nx][ny] == '1'){
                            uf.union(x*col+y, nx*col+ny);
                        }
                    }
                }
            }
        }
        return uf.getCount() - water;
    }
}

class UF{
    int[] parent;
    int[] rank;
    int count;

    public UF(char[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        count = row * col;

        parent = new int[count];
        for(int i = 0; i < count; i++){
            parent[i] = i;
        }
        rank = new int[count];
    }

    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px != py){
            if(rank[px] > rank[py]){
                parent[py] = px;
            }else if(rank[px] < rank[py]){
                parent[px] = py;
            }else{
                parent[py] = px;
                rank[px]++;
            }
            count--;
        }
    }

    public int getCount(){
        return count;
    }
}
