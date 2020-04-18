package notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 题目：递增的三元子序列 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 * https://leetcode-cn.com/problems/increasing-triplet-subsequence/
 * 题解：https://leetcode-cn.com/problems/increasing-triplet-subsequence/solution/c-xian-xing-shi-jian-fu-za-du-xiang-xi-jie-xi-da-b/
 *
 * @author: wengchuqin
 * @create: 2020-04-06 16:47
 */
public class IncreasingTripletSubsequence {
    @Test
    public void test() {
        Assert.assertTrue(new Solution().increasingTriplet(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void test2() {
        Assert.assertFalse(new Solution().increasingTriplet(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    public void test3() {
        Assert.assertFalse(new Solution().increasingTriplet(new int[]{}));
        Assert.assertFalse(new Solution().increasingTriplet(new int[]{1}));
        Assert.assertFalse(new Solution().increasingTriplet(new int[]{1, 2}));
    }

    @Test
    public void test4() {
        Assert.assertTrue(new Solution().increasingTriplet(new int[]{5, 1, 5, 5, 2, 5, 4}));
    }


    @Test
    public void test5() {
        Assert.assertTrue(new Solution().increasingTriplet(new int[]{5, 8, 6, 7}));
    }


    /**
     * 首先，新建两个变量 small 和 mid ，分别用来保存题目要我们求的长度为 3 的递增子序列的最小值和中间值。
     * 接着，我们遍历数组，每遇到一个数字，我们将它和 small 和 mid 相比，若小于等于 small ，则替换 small；
     * 否则，若小于等于 mid，则替换 mid；
     * 否则，若大于 mid，则说明我们找到了长度为 3 的递增数组！
     */
    class Solution {
        public boolean increasingTriplet(int[] nums) {
            int small = Integer.MAX_VALUE;
            int mid = Integer.MAX_VALUE;
            for (int n : nums) {
                System.out.printf("small:%s, mid:%s, n:%s, nums:%s\n", small, mid, n, Arrays.toString(nums));
                if (small >= n) {
                    small = n;
                } else if (mid >= n) {
                    mid = n;
                } else {
                    return true;
                }
            }
            return false;

        }
    }
}
