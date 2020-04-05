package wcq.learning.java.notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 题目：给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * https://leetcode-cn.com/problems/word-break/
 *
 * @author: wengchuqin
 * @create: 2020-04-05 15:34
 */
public class WordBreak {
    @Test
    public void test() {
        Assert.assertTrue(new Solution().wordBreak("leetcode", Arrays.asList("leet", "code")));
    }

    @Test
    public void test2() {
        Assert.assertTrue(new Solution().wordBreak("leetcode", Arrays.asList("leetcode", "code")));
    }

    @Test
    public void test3() {
        Assert.assertFalse(new Solution().wordBreak("lee", Arrays.asList("leetcode", "code")));
    }

    @Test
    public void test4() {
        Assert.assertTrue(new Solution().wordBreak("", Arrays.asList("leetcode", "code")));
    }

    @Test
    public void test5() {
        Assert.assertTrue(new Solution().wordBreak("leetcodeleetcodeleetcodeleetcode", Arrays.asList("leetcode", "code")));
    }

    public class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            return new Help(s, wordDict).wordBreak();
        }

        /**
         * 超时了
         */
        class Help {
            final String s;
            final Collection<String> wordDict;

            public Help(String s, Collection<String> wordDict) {
                this.s = s;
                this.wordDict = new HashSet<>(wordDict);
            }

            public boolean wordBreak() {
                return iterate(s);
            }

            public boolean iterate(String s) {
                if (s.isEmpty()) {
                    return true;
                }


                for (int i = 1; i <= s.length(); i++) {
                    if (wordDict.contains(s.substring(0, i)) && iterate(s.substring(i))) {
                        return true;
                    }
                }
                return false;
            }
        }

        class Help2 {
            final String s;
            final Collection<String> wordDict;
            final HashMap<String, Boolean> memo;

            public Help2(String s, Collection<String> wordDict) {
                this.s = s;
                this.wordDict = new HashSet<>(wordDict);
                this.memo = new HashMap<>();
            }

            public boolean wordBreak() {
                return iterate(s);
            }

            public boolean iterate(String s) {
                if (s.isEmpty()) {
                    memo.put(s, true);
                    return true;
                }

                System.out.println("memo: " + memo);
                Boolean flag = memo.get(s);
                if (flag != null) {
                    System.out.println("xxx");
                    return flag;
                }

                for (int i = 1; i <= s.length(); i++) {
                    if (wordDict.contains(s.substring(0, i)) && iterate(s.substring(i))) {
                        memo.put(s, true);
                        return true;
                    }
                }
                memo.put(s, false);
                return false;
            }
        }
    }
}
