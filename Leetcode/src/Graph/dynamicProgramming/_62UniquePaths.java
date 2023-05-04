package dynamicProgramming;

import java.util.Arrays;

/**
 * @Author: mianmiantea2019
 * @Date: 2023-05-03 7:15 PM
 * @LastEditors: mianmiantea2019
 * @Description:
 */

public class _62UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for(int i = 0; i <m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j== 0){
                    f[i][j] = 1;
                }else{
                    f[i][j] = f[i-1][j]+f[i][j-1];
                }
            }
        }
        for(int i = 0; i < m; i++){
            System.out.println(Arrays.toString(f[i]));
        }
        return f[m-1][n-1];
    }
}
