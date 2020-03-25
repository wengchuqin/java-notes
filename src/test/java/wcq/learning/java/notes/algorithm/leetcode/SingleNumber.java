package wcq.learning.java.notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 题目：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 https://leetcode-cn.com/problems/single-number/
 *
 * @author: wengchuqin
 * @create: 2020-03-25 22:26
 */
public class SingleNumber {
    @Test
    public void test() {
        Assert.assertEquals(1, new Solution().singleNumber(new int[]{2, 2, 1}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(4, new Solution().singleNumber(new int[]{4, 1, 2, 1, 2}));
    }


    @Test
    public void test3() {
        Assert.assertEquals(4, new Solution().singleNumber(new int[]{4}));
    }


    class Solution {
        public int singleNumber(int[] nums) {
            return Arrays.stream(nums)
                    .parallel()
                    .reduce((n1, n2) -> n1 ^ n2)
                    .orElseThrow(IllegalArgumentException::new);
        }
    }
}
