package BinarySearch;

/**
 * @Author: mianmiantea2019
 * @Date: 2023-05-03 7:15 PM
 * @LastEditors: mianmiantea2019
 * @Description:
 */

public class _59SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 1;
        int startRow = 0, endRow = n - 1;
        int startCol = 0, endCol = n - 1;

        while (startRow <= endRow && startCol <= endCol) { //这个条件来保证当前层存在,至少存在一个元素
            // 模拟上侧从左到右;走到最后一Col |
            for (int col = startCol; col <= endCol; col++) {
                res[startRow][col] = count++;
            }
            print(n, res);

            // 模拟右侧从上到下,走到最后一Row -   如果只有一个元素,只有一行 Row 不会进入
            for (int row = startRow + 1; row <= endRow; row++) {
                res[row][endCol] = count++;
            }

            print(n, res);

            if (startRow < endRow && startCol < endCol) {
                // 模拟下侧从右到左
                for (int col = endCol - 1; col > startCol; col--) { //开始点不在第一个col | 上面
                    res[endRow][col] = count++;
                }

                print(n, res);
                // 模拟左侧从下到上
                for (int row = endRow; row > startRow; row--) { //开始点不在第一row上面 -
                    res[row][startCol] = count++;
                }
                print(n, res);
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return res;
    }

    private void print(int n, int[][] res) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        _59SpiralMatrixII solution = new _59SpiralMatrixII();
//        int n = 3;
//        int n = 1;
//        int n = 2;
        int n = 2;
        int[][] matrix = solution.generateMatrix(n);
        solution.print(n, matrix);
    }
}
