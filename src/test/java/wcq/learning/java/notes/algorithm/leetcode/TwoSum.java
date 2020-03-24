package wcq.learning.java.notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: wengchuqin
 * @create: 2020-03-21 17:32
 */
public class TwoSum {
    private static final Logger logger = LoggerFactory.getLogger(WaterAndJugProblem.class);

    private class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }
    }

   private class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> valueIndexMap = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                Integer value = valueIndexMap.get(target - nums[i]);
                if (value != null) {
                    return new int[]{i, value};
                }

                valueIndexMap.put(nums[i], i);
            }

            throw new IllegalArgumentException("No two sum solution");
        }
    }


    @Test
    public void test1() {
        Solution s = new Solution();
        int[] result = s.twoSum(new int[]{2, 7, 11, 15}, 9);
        Assert.assertEquals(result[0], 0);
        Assert.assertEquals(result[1], 1);
    }


    @Test
    public void test2() {
        Solution2 s = new Solution2();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = s.twoSum(nums, target);
        Assert.assertEquals(nums[result[0]] + nums[result[1]], target);

    }


    @Test
    public void test3() {
        Solution2 s = new Solution2();
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = s.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
        Assert.assertEquals(nums[result[0]] + nums[result[1]], target);
    }
}
