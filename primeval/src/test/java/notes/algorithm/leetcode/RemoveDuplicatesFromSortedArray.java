package notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 题目：删除排序数组中的重复项 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author: wengchuqin
 * @create: 2020-03-29 22:32
 */
public class RemoveDuplicatesFromSortedArray {
    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 2};
        Assert.assertEquals(2, new Solution().removeDuplicates(nums));
        Assert.assertArrayEquals(new int[]{1, 2}, Arrays.copyOf(nums, 2));
    }

    @Test
    public void test2() {
        int[] nums = new int[]{1};
        Assert.assertEquals(1, new Solution().removeDuplicates(nums));
        Assert.assertArrayEquals(new int[]{1}, Arrays.copyOf(nums, 1));
    }


    @Test
    public void test3() {
        int[] nums = new int[]{};
        Assert.assertEquals(0, new Solution().removeDuplicates(nums));
        Assert.assertArrayEquals(new int[]{}, Arrays.copyOf(nums, 0));
    }

    @Test
    public void test4() {
        int[] nums = new int[]{1, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Assert.assertEquals(9, new Solution().removeDuplicates(nums));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, Arrays.copyOf(nums, 9));
    }


    /**
     * 双指针，p1, p2, p2指针找到比p1大的数字, 并放在p1后面
     */
    class Solution {
        public int removeDuplicates(int[] nums) {
            int duplicateCount = 0;
            for (int p1 = 0, p2 = 1; p2 < nums.length; ) {
                if (nums[p2] == nums[p1]) {
                    duplicateCount++;
                    p2++;
                } else {
                    p1++;
                    nums[p1] = nums[p2];
                    p2++;
                }
            }

            return nums.length - duplicateCount;
        }
    }

    /**
     * 暴力法
     */
    class Solution2 {
        public int removeDuplicates(int[] nums) {
            int duplicateCount = 0;
            int i = 1;
            for (int c = 0; c < nums.length - 1; c++) {
                if (nums[i - 1] == nums[i]) {
                    duplicateCount++;
                    for (int j = i + 1; j < nums.length; j++) {
                        nums[j - 1] = nums[j];
                    }
                } else {
                    i++;
                }
            }
            return nums.length - duplicateCount;
        }
    }
}
