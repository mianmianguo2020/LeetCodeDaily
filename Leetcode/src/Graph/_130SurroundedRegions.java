/*
 * @Author: mianmianguo2020
 * @Date: 2023-05-01 23:08:29
 * @LastEditors: mianmianguo2020
 * @LastEditTime: 2023-05-02 00:25:33
 * @Description: 
 */

import java.util.Arrays;

class _130SurroundedRegions {
        public void solve(char[][] board) {
            int m = board.length;
            int n = board[0].length;
    
            boolean[][] visited = new boolean[m][n];
    
            for (int i = 0; i < n; i++) {
                if (board[0][i] == 'O') {
                    dfs(board, visited, 0, i);
                }
                if (board[m - 1][i] == 'O') {
                    dfs(board, visited, m - 1, i);
                }
            }
            
            for (int i = 0; i < m; i++) {
                if (board[i][0] == 'O') {
                    dfs(board, visited, i, 0);
                }
                if (board[i][n - 1] == 'O') {
                    dfs(board, visited, i, n - 1);
                }
            }
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'O' && !visited[i][j]) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    
        private void dfs(char[][] board, boolean[][] visited, int i, int j) {
            int m = board.length;
            int n = board[0].length;
    
            if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] == 'X') {
                return;
            }
    
            visited[i][j] = true;
    
            dfs(board, visited, i - 1, j); 
            dfs(board, visited, i + 1, j); 
            dfs(board, visited, i, j - 1); 
            dfs(board, visited, i, j + 1); 
        }
    }
}
