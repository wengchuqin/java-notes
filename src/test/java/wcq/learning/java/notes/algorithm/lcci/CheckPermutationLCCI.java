package wcq.learning.java.notes.algorithm.lcci;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 题目：判定是否互为字符重排
 * https://leetcode-cn.com/problems/check-permutation-lcci/
 * 解法一：将字符数组排序，对比两个数组是否相同
 * 解法二：使用把字符串转成Map<字符, 计数>, 对比两个Map。 如果字符全是字符串，可以使用int[48]来做Map。
 *
 * @author: wengchuqin
 * @create: 2020-04-06 23:25
 */
public class CheckPermutationLCCI {
    @Test
    public void test() {
        Assert.assertTrue(new Solution().CheckPermutation("abc", "bca"));
        Assert.assertFalse(new Solution().CheckPermutation("abc", "bc"));
    }


    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            char[] a1 = s1.toCharArray();
            char[] a2 = s2.toCharArray();

            Arrays.sort(a1);
            Arrays.sort(a2);

            return Arrays.equals(a1, a2);
        }
    }


}
