package notes.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: wengchuqin
 * @create: 2020-03-22 17:57
 */
public class ImageSmoother {
    @Test
    public void test() {
        int M[][] = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1},
        };
        System.out.println(Arrays.deepToString(new Solution().imageSmoother(M)));
    }

    @Test
    public void test2() {
        int M[][] = new int[][]{
                {2, 3, 4},
                {5, 6, 7},
                {8, 9, 10},
                {11, 12, 13},
                {14, 15, 16}};
        System.out.println(Arrays.deepToString(new Solution().imageSmoother(M)));
    }


    class Solution {
        public int[][] imageSmoother(int[][] M) {
            int r = M.length;
            int c = M[0].length;
            int[][] ans = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    int r1 = i - 1 < 0 ? 0 : i - 1;
                    int r2 = i + 1 >= r ? r - 1 : i + 1;
                    int c1 = j - 1 < 0 ? 0 : j - 1;
                    int c2 = j + 1 >= c ? c - 1 : j + 1;

                    int count = 0;
                    int sum = 0;
//                    System.out.printf("r1:%s, r2:%s, c1:%s, c2:%s, count:%s, sum:%s\n", r1, r2, c1, c2, count, sum);
                    for (int m = r1; m <= r2; m++) {
                        for (int n = c1; n <= c2; n++) {
//                            System.out.println("count++");
                            count++;
                            sum += M[m][n];
                        }
                    }
//                    System.out.printf("%s / %s == %s\n", sum, count, sum / count);
                    ans[i][j] = sum / count;
                }
            }

            return ans;
        }
    }
}
