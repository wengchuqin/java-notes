package notes.algorithm.lcci.c01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static notes.algorithm.leetcode.common.MatrixHelper.print;

/**
 * 题目：编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * https://leetcode-cn.com/problems/zero-matrix-lcci/
 * 题解：（1）找到并记录所有值为0的坐标。记为zeroPoints。（2）根据zeroPoints，把相关的行和列清零。
 *
 * @author: wengchuqin
 * @create: 2020-05-07 21:58
 */
public class ZeroMatrixLCCI {
    @Test
    public void test() {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1},
        };
        print(matrix);

        new ZeroMatrixLCCI.Solution().setZeroes(matrix);
        System.out.println("----");
        print(matrix);
    }

    @Test
    public void test2() {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        print(matrix);

        new ZeroMatrixLCCI.Solution().setZeroes(matrix);
        System.out.println("----");
        print(matrix);
    }


    class Solution {
        public void setZeroes(int[][] matrix) {
            //（1）找到并记录所有值为0的坐标。记为zeroPoints。
            List<Point> zeroPoints = new ArrayList<>();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0) {
                        zeroPoints.add(new Point(i, j));
                    }
                }
            }


            //（2）根据zeroPoints，把相关的行和列清零。
            zeroPoints.forEach(p -> {
                int x = p.x;
                for (int i = 0; i < matrix[x].length; i++) {
                    matrix[x][i] = 0;
                }

                int y = p.y;
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][y] = 0;
                }
            });
        }

        class Point {
            int x;
            int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public String toString() {
                return String.format("(%s, %s)", x, y);
            }

        }
    }


}
