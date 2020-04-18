package notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static java.util.Arrays.asList;

/**
 * 题目：给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 返回 s 所有可能的分割方案。
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * <p>
 * 题解：回溯法 https://leetcode-cn.com/problems/palindrome-partitioning/solution/hui-su-you-hua-jia-liao-dong-tai-gui-hua-by-liweiw/
 *
 * @author: wengchuqin
 * @create: 2020-04-04 19:05
 */
public class PalindromePartitioningMine {
    @Test
    public void test() {
        Solution solution = new Solution();
        String s = "aabbccedf";
        Assert.assertTrue(solution.new Help(s).checkPalindrome(0, 0));
        Assert.assertTrue(solution.new Help(s).checkPalindrome(0, 1));
        Assert.assertFalse(solution.new Help(s).checkPalindrome(0, 2));
        Assert.assertFalse(solution.new Help(s).checkPalindrome(5, 6));
    }

    @Test
    public void test2() {
        System.out.println(new Solution().partition("aab"));
        Assert.assertEquals(asList(asList("a", "a", "b"), asList("aa", "b")), new Solution().partition("aab"));
    }

    @Test
    public void test3() {
        System.out.println(new Solution().partition("a"));
    }

    @Test
    public void test4() {
        System.out.println(new Solution().partition(""));
    }

    @Test
    public void test5() {
        System.out.println(new Solution().partition("aabbcc"));
    }

    @Test
    public void test6() {
        Assert.assertEquals(asList(asList("e", "f", "e"), asList("efe")), new Solution().partition("efe"));
    }

    public class Solution {

        public List<List<String>> partition(String s) {
            return new Help(s).partition();
        }

        class Help {
            final String s;
            final Stack<String> pathStack;
            final List<List<String>> result;

            public Help(String s) {
                this.s = s;
                this.pathStack = new Stack<>();
                this.result = new ArrayList<>();
            }

            public List<List<String>> partition() {
                backtracking(0);
                return result;
            }

            private void backtracking(int start) {
                if (start == s.length()) {
                    result.add(new ArrayList<>(pathStack));
                }

                for (int i = start; i < s.length(); i++) {
//                    System.out.printf("pathStack:%s, i:%s\n", pathStack, i);
                    if (!checkPalindrome(start, i)) {
                        continue;
                    }
                    pathStack.push(s.substring(start, i + 1));
                    backtracking(i + 1);
                    pathStack.pop();
                }
            }

            /**
             * 判断是不是回文串
             *
             * @param start
             * @param end
             * @return
             */
            private boolean checkPalindrome(int start, int end) {
                for (int i = start, j = end; i <= j; i++, j--) {
                    if (s.charAt(i) != s.charAt(j)) {
                        return false;
                    }
                }
                return true;
            }
        }
    }
}
