package notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 题目：按摩师 https://leetcode-cn.com/problems/the-masseuse-lcci/
 *
 * @author: wengchuqin
 * @create: 2020-03-24 21:52
 */
public class TheMasseuseLCCI {
    @Test
    public void test() {
        Assert.assertEquals(4, new Solution().massage(new int[]{1, 2, 3, 1}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(12, new Solution().massage(new int[]{2, 7, 9, 3, 1}));
    }


    @Test
    public void test3() {
        Assert.assertEquals(1, new Solution().massage(new int[]{1}));
    }

    @Test
    public void test4() {
        Assert.assertEquals(1, new Solution().massage(new int[]{1, 1}));
    }


    class Solution {
        /**
         * 题目：一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
         * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
         * <p>
         * 例如：输入： [2,7,9,3,1]   输出： 12
         * <p>
         * <p>
         * 分析：
         * 定义 dp[i][0]dp[i][0] 表示考虑前 i 个预约，第 i 个预约不接的最长预约时间。dp[i][1] 表示考虑前 i 个预约，第 i 个预约接的最长预约时间。
         * 那么：dp[i][0] = max(dp[i-1][0], dp[i-1][1]) 。 dp[i][1] = dp[i-1][0] + nums[i]
         * 最后答案为：max(dp[i][0], dp[i][1])
         *
         * @param nums
         * @return
         */
        public int massage(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            //前一个预约不接的最长预约时间
            int dp0 = 0;
            //前一个预约接的最长预约时间
            int dp1 = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int tmpDp0 = Math.max(dp0, dp1);
                int tmpDp1 = dp0 + nums[i];

                dp0 = tmpDp0;
                dp1 = tmpDp1;
            }


            return Math.max(dp0, dp1);
        }


    }


    //耗时太长
    class Solution2 {
        public int massage(int[] nums) {
            return iterate(nums, 0, 0);
        }

        int iterate(int[] nums, int index, int sum) {
            if (index >= nums.length) {
                return sum;
            }

            return Math.max(
                    iterate(nums, index + 1, sum),
                    iterate(nums, index + 2, sum + nums[index])
            );
        }
    }
}
