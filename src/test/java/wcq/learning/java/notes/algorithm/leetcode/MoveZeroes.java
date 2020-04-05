package wcq.learning.java.notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 题目：移动零
 * https://leetcode-cn.com/problems/move-zeroes/
 * 题解：使用快慢指针，慢指针指向0，快指针遇到非0时，交换位置。
 *
 * @author: wengchuqin
 * @create: 2020-04-05 22:59
 */
public class MoveZeroes {
    @Test
    public void test() {
        int[] nums = {0, 1, 0, 3, 12};
        new Solution().moveZeroes(nums);
        Assert.assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);
    }

    @Test
    public void test2() {
        int[] nums = {0, 1};
        new Solution().moveZeroes(nums);
        Assert.assertArrayEquals(new int[]{1, 0}, nums);
    }

    @Test
    public void test3() {
        int[] nums = {0};
        new Solution().moveZeroes(nums);
        Assert.assertArrayEquals(new int[]{0}, nums);
    }

    @Test
    public void test4() {
        int[] nums = {};
        new Solution().moveZeroes(nums);
        Assert.assertArrayEquals(new int[]{}, nums);
    }

    @Test
    public void test5() {
        int[] nums = {1, 0};
        new Solution().moveZeroes(nums);
        Assert.assertArrayEquals(new int[]{1, 0}, nums);
    }

    @Test
    public void test6() {
        int[] nums = {1, 0, 2, 0, 0, 3};
        new Solution().moveZeroes(nums);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 0, 0, 0}, nums);
    }


    class Solution {
        public void moveZeroes(int[] nums) {
            for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
                if (nums[cur] != 0) {
                    change(nums, lastNonZeroFoundAt, cur);
                    lastNonZeroFoundAt++;
                }
            }
        }


        public void change(int[] arr, int p1, int p2) {
            int tmp = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = tmp;
        }
    }
}
