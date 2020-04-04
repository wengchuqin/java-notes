package wcq.learning.java.notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 题目：给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 https://leetcode-cn.com/problems/valid-palindrome/
 *
 * @author: wengchuqin
 * @create: 2020-04-04 18:29
 */
public class ValidPalindrome {
    @Test
    public void test() {
        Assert.assertTrue(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void test2() {
        Assert.assertFalse(new Solution().isPalindrome("race a car"));
    }

    @Test
    public void test3() {
        Assert.assertTrue(new Solution().isPalindrome("r"));
    }

    @Test
    public void test4() {
        Assert.assertTrue(new Solution().isPalindrome("r     "));
    }

    @Test
    public void test5() {
        Assert.assertTrue(new Solution().isPalindrome("*"));
    }


    @Test
    public void test6() {
        Assert.assertTrue(new Solution().isPalindrome(""));
    }

    @Test
    public void test7() {
        Assert.assertFalse(new Solution().isPalindrome("0p"));
    }


    class Solution {
        public boolean isPalindrome(String s) {
            for (int p1 = 0, p2 = s.length() - 1; p1 < p2; ) {
                if (!isAlphabeticOrDigit(s.charAt(p1))) {
                    p1++;
                } else if (!isAlphabeticOrDigit(s.charAt(p2))) {
                    p2--;
                } else if (!equalsIgnoreCase(s.charAt(p1), s.charAt(p2))) {
                    return false;
                } else {
                    p1++;
                    p2--;
                }
            }
            return true;
        }

        private boolean isAlphabeticOrDigit(char c) {
            return Character.isAlphabetic(c) || Character.isDigit(c);
        }

        private boolean equalsIgnoreCase(char c1, char c2) {
            return Character.toLowerCase(c1) == Character.toLowerCase(c2);
        }
    }


}
