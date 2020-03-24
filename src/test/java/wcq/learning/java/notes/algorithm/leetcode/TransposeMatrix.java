package wcq.learning.java.notes.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: wengchuqin
 * @create: 2020-03-22 22:28
 */
public class TransposeMatrix {
    @Test
    public void test1(){
        int[][] A = new int[][]{
                {1,2,3},
                {4,5,6},
        };

        int[][] B = new Solution().transpose(A);
        System.out.println(Arrays.deepToString(B));
    }

    @Test
    public void test2(){
        int[][] A = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };

        int[][] B = new Solution().transpose(A);
        System.out.println(Arrays.deepToString(B));
    }


    @Test
    public void test3(){
        int[][] A = new int[][]{
                {1,2,3},
        };

        int[][] B = new Solution().transpose(A);
        System.out.println(Arrays.deepToString(B));
    }



    class Solution {
        public int[][] transpose(int[][] A) {
            int r = A.length;
            int c = A[0].length;

            int[][] B = new int[c][r];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    B[j][i] = A[i][j];
                }
            }

            return B;
        }
    }
}
