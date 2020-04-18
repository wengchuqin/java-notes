package notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：给定一个整数数组，判断是否存在重复元素。
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons/264/array/1129/
 *
 * @author: wengchuqin
 * @create: 2020-04-05 22:32
 */
public class ContainsDuplicate {
    @Test
    public void test() {
        Assert.assertTrue(new Solution().containsDuplicate(new int[]{1, 2, 2}));
        Assert.assertFalse(new Solution().containsDuplicate(new int[]{1, 2, 3}));
        Assert.assertFalse(new Solution().containsDuplicate(new int[]{}));
    }

    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int n : nums) {
                if (set.contains(n)) {
                    return true;
                } else {
                    set.add(n);
                }
            }
            return false;
        }
    }
}
