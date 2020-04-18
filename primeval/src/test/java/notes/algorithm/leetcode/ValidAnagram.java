package notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * https://leetcode-cn.com/problems/valid-anagram/
 * <p>
 * 解法一：字符串转数组，将数组排序
 * 解法二：使用hash表记录字母出现次数
 *
 * @author: wengchuqin
 * @create: 2020-04-05 17:37
 */
public class ValidAnagram {
    @Test
    public void test() {
        Assert.assertTrue(new Solution().isAnagram("anagram", "nagaram"));
    }

    @Test
    public void test2() {
        Assert.assertFalse(new Solution().isAnagram("rat", "car"));
    }

    @Test
    public void test3() {
        Assert.assertFalse(new Solution().isAnagram("", "car"));
    }

    @Test
    public void test4() {
        Assert.assertTrue(new Solution().isAnagram("", ""));
    }


    class Solution {
        public boolean isAnagram(String s, String t) {
            char[] sArr = s.toCharArray();
            char[] tArr = t.toCharArray();

            Arrays.sort(sArr);
            Arrays.sort(tArr);

            return Arrays.equals(sArr, tArr);
        }
    }
}
