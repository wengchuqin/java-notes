package wcq.learning.java.notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 *
 * @author: wengchuqin
 * @create: 2020-03-25 23:10
 */
public class SearchA2DMatrixII {
    @Test
    public void test() {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 5;
        Assert.assertTrue(new Solution().searchMatrix(matrix, target));
    }

    @Test
    public void test2() {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 20;
        Assert.assertFalse(new Solution().searchMatrix(matrix, target));
    }

    @Test
    public void test3() {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
        };
        int target = 7;
        Assert.assertTrue(new Solution().searchMatrix(matrix, target));
    }

    @Test
    public void test4() {
        int[][] matrix = new int[][]{
                {1, 4},
        };
        int target = 4;
        Assert.assertTrue(new Solution().searchMatrix(matrix, target));
    }

    @Test
    public void test5() {
        int[][] matrix = new int[][]{
                {1},
                {4}
        };
        int target = 4;
        Assert.assertTrue(new Solution().searchMatrix(matrix, target));
    }


    @Test
    public void test6() {
        int[][] matrix = new int[][]{
                {1},
                {24},
                {34},
                {44},
                {54},
                {64},
                {74},
                {84},
                {94},
                {104},
        };
        int target = 24;
        Assert.assertTrue(new Solution().searchMatrix(matrix, target));
    }


    @Test
    public void test7() {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        int target = 15;
        Assert.assertTrue(new Solution().searchMatrix(matrix, target));
    }


    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0) {
                return false;
            }

            int r1 = 0;
            int r2 = matrix.length - 1;
            int c1 = 0;
            int c2 = matrix[0].length - 1;
            while (true) {
                System.out.printf("p1:(%s, %s), p2(%s, %s)\n", r1, c1, r2, c2);
//                if (r2 - r1 <= 1 && c2 - c1 <= 1) {
//                    for (int i = r1; i <= r2; i++) {
//                        for (int j = c1; j <= c2; j++) {
//                            if (matrix[i][j] == target) {
//                                return true;
//                            }
//                        }
//                    }
//                    return false;
//                }

                if(r2 < r1 || c2 < c1){
                    return false;
                }

                int mr = (r1 + r2) / 2;
                int mc = (c1 + c2) / 2;
                if (matrix[mr][mc] == target) {
                    return true;
                } else if (matrix[mr][mc] > target) {
                    r2 = Math.min(mr, r2 - 1);
//                    c2 = mc;
                } else {
//                    r1 = mr;
//                    c1 = mc;
                    c1 = Math.max(mc, c1 + 1);
                }
            }

        }
    }
}
