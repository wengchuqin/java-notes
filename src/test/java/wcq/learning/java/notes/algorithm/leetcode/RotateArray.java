package wcq.learning.java.notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 题目：给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * https://leetcode-cn.com/problems/rotate-array/
 * <p>
 * 解法一：使用暴力法，每次旋转一个位置，旋转k次。
 * 解法二：使用额外数组，把旋转结果放置到额外数组中
 * 解法三：使用反转
 *
 * @author: wengchuqin
 * @create: 2020-04-05 22:10
 */
public class RotateArray {
    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new Solution().rotate(nums, 3);
        Assert.assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, nums);
    }

    @Test
    public void test2() {
        int[] nums = {1, 2};
        new Solution().rotate(nums, 1);
        Assert.assertArrayEquals(new int[]{2, 1}, nums);
    }

    @Test
    public void test3() {
        int[] nums = {1};
        new Solution().rotate(nums, 10);
        Assert.assertArrayEquals(new int[]{1}, nums);
    }

    @Test
    public void test4() {
        int[] nums = {};
        new Solution().rotate(nums, 10);
        Assert.assertArrayEquals(new int[]{}, nums);
    }

    class Solution {
        /**
         * 反转法
         * 输入: [1,2,3,4,5,6,7] 和 k = 3
         * 输出: [5,6,7,1,2,3,4]
         * 执行步骤：
         * [7, 6, 5, 4, 3, 2, 1]
         * [5, 6, 7, 4, 3, 2, 1]
         * [5, 6, 7, 1, 2, 3, 4]
         */
        public void rotate(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return;
            }

            k = k % nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        public void reverse(int[] nums, int start, int end) {
            for (int i = start, j = end; i <= j; i++, j--) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
    }
}
