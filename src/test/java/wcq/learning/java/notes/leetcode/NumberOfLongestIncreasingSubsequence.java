package wcq.learning.java.notes.leetcode;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * 题目：https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/
 *
 * @author: wengchuqin
 * @create: 2020-03-22 12:20
 */
public class NumberOfLongestIncreasingSubsequence {
    private static final Logger logger = LoggerFactory.getLogger(NumberOfLongestIncreasingSubsequence.class);

    @Test
    public void test() {
        Assert.assertEquals(4, new Solution().findNumberOfLIS(new int[]{1,3,5,4,7}));
        Assert.assertEquals(5, new Solution().findNumberOfLIS(new int[]{2,2,2,2,2}));
        Assert.assertEquals(1, new Solution().findNumberOfLIS(new int[]{1}));
        Assert.assertEquals(0, new Solution().findNumberOfLIS(new int[]{}));

    }

    private class Solution {

        public int findNumberOfLIS(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            //dp[i]：以第 i 个数字结尾的最长上升子序列的长度
            int[] dp = new int[nums.length];

            //dp2[i]：以第 i 个数字结尾的最长递增子序列的个数
//            int[] dp2 = new int[nums.length];

            dp[0] = 1;
            int maxans = 1;

            for (int i = 1; i < nums.length; i++) {
                logger.info("i = {}", i);
                int maxTmp = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        logger.info("{} > {}", nums[i], nums[j]);
                        maxTmp = Math.max(maxTmp, dp[j] + 1);
                    }
                }
                dp[i] = maxTmp;
                maxans = Math.max(maxans, maxTmp);

                logger.info("dp: {}", Arrays.toString(dp));
                logger.info("");
            }


            int count = 0;
            for (int max : dp) {
                if (max == maxans) {
                    count++;
                }
            }

            return count;
        }
    }


}
