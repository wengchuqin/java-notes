package wcq.learning.java.notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 题目：最大子序和 https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @author: wengchuqin
 * @create: 2020-03-23 21:52
 */
public class MaximumSubarray {
    @Test
    public void test() {
        Assert.assertEquals(6, new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(-1, new Solution().maxSubArray(new int[]{-1}));
    }


    @Test
    public void test3() {
        Assert.assertEquals(1, new Solution().maxSubArray(new int[]{-1, 1}));
    }

    @Test
    public void test4() {
        Assert.assertEquals(3, new Solution().maxSubArray(new int[]{1, 1, 1}));
    }


    class Solution {
        public int maxSubArray(int[] nums) {
            int curValSum = 0;
            int maxValSum = Integer.MIN_VALUE;

            for (int n : nums) {

                if (curValSum + n < n) {  //加完比当前总和还小，就抛弃掉
                    curValSum = n;
//                    System.out.print("重新一个子序列");
                } else {
                    curValSum += n;
//                    System.out.print("累加");
                }

                if (curValSum > maxValSum) {
                    maxValSum = curValSum;
                }
//                System.out.printf("n:%s, curValSum:%s  maxValSum:%s  \n", n, curValSum, maxValSum);
            }

            return maxValSum;
        }
    }
}
