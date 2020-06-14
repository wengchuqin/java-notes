package notes.algorithm.leetcode.common;

/**
 * @author: wengchuqin
 * @create: 2020-04-19 16:29
 */
public class MatrixHelper {
    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
