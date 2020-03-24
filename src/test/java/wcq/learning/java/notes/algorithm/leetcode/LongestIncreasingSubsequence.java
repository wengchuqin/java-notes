package wcq.learning.java.notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * 最长上升子序列
 * 题目：https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 题解：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/
 *
 * @author: wengchuqin
 * @create: 2020-03-22 15:11
 */
public class LongestIncreasingSubsequence {
    private static final Logger logger = LoggerFactory.getLogger(LongestIncreasingSubsequence.class);

    @Test
    public void test() {
//        Assert.assertEquals(4, new Solution().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
//        Assert.assertEquals(1, new Solution().lengthOfLIS(new int[]{5, 5, 5}));
        Assert.assertEquals(3, new Solution().lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
    }

    private class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            //dp[i]：以第 i 个数字结尾的最长上升子序列的长度
            int[] dp = new int[nums.length];
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


            return maxans;
        }
    }

//    private class Solution {
//        public int lengthOfLIS(int[] nums) {
//            if (nums.length == 0) {
//                return 0;
//            }
//            int[] dp = new int[nums.length];
//            dp[0] = 1;
//            int maxans = 1;
//            for (int i = 1; i < dp.length; i++) {
//                int maxval = 0;
//                for (int j = 0; j < i; j++) {
//                    if (nums[i] > nums[j]) {
//                        maxval = Math.max(maxval, dp[j]);
//                    }
//                }
//                dp[i] = maxval + 1;
//                maxans = Math.max(maxans, dp[i]);
//            }
//            return maxans;
//        }
//    }
}
