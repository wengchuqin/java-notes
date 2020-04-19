package notes.algorithm.lcci.c01;

import org.junit.Assert;
import org.junit.Test;

/**
 * 题目：字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * https://leetcode-cn.com/problems/one-away-lcci/
 * 题解一：如果是 插入一个字符、删除一个字符，那么两个字符串长度相差1，且只有一个字符不一致。 如果是 替换一个字符，那么字符串长度相同，且只有一个字符不一致。
 *
 * @author: wengchuqin
 * @create: 2020-04-07 22:58
 */
public class OneAwayLCCI {
    @Test
    public void test() {
        Assert.assertTrue(new Solution().oneEditAway("pale", "ple"));
        Assert.assertTrue(new Solution().oneEditAway("pale", "pale"));
        Assert.assertTrue(new Solution().oneEditAway("pale", "pele"));
        Assert.assertTrue(new Solution().oneEditAway("", ""));
        Assert.assertTrue(new Solution().oneEditAway("", "a"));
        Assert.assertTrue(new Solution().oneEditAway("a", ""));
        Assert.assertFalse(new Solution().oneEditAway("aa", ""));
        Assert.assertFalse(new Solution().oneEditAway("pale", "pe"));
    }


    class Solution {
        public boolean oneEditAway(String first, String second) {
            if (first.length() == second.length()) {
                if (checkSameOrReplaceOnce(first, second)) {
                    return true;
                }
            } else if (first.length() > second.length()) {
                if (delOnce(first, second)) {
                    return true;
                }
            } else {
                if (delOnce(second, first)) {
                    return true;
                }
            }
            return false;
        }

        private boolean delOnce(String longStr, String shortStr) {
            if (longStr.length() != shortStr.length() + 1) {
                return false;
            }
            for (int l = 0, s = 0; l < longStr.length() && s < shortStr.length(); ) {
                if (longStr.charAt(l) == shortStr.charAt(s)) {
                    l++;
                    s++;
                } else {
                    l++;
                    if (l == s + 2) {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean checkSameOrReplaceOnce(String first, String second) {
            int error = 0;
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    error++;
                    if (error > 1) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
