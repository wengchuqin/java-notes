package wcq.learning.java.notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目：给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 *
 * @author: wengchuqin
 * @create: 2020-04-05 20:32
 */
public class MaximumProductSubarray {
    @Test
    public void test() {
        Assert.assertEquals(6, new Solution().maxProduct(new int[]{2, 3, -2, 4}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, new Solution().maxProduct(new int[]{0, 2}));
    }

    class Solution {
        public int maxProduct(int[] nums) {
            System.out.println(Arrays.toString(nums));
            return new Help(nums).maxProduct(0);
        }

        class Help {
            final int[] nums;
            final Map<Integer, Integer> memo;

            public Help(int[] nums) {
                this.nums = nums;
                this.memo = new HashMap<>();
            }

            public int maxProduct(int i) {
                System.out.println("i:" + i);
                if (i >= nums.length) {
                    return 1;
                }

                return Math.max(maxProduct(i + 1) * nums[i], maxProduct(i + 1));
            }
        }
    }
}
