package notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;
import java.util.Stack;

/**
 * 题目：https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 *
 * @author: wengchuqin
 * @create: 2020-03-22 16:16
 */
public class SplitAStringInBalancedStrings {
    @Test
    public void test() {
        Assert.assertEquals(4, new Solution().balancedStringSplit("RLRRLLRLRL"));
        Assert.assertEquals(3, new Solution().balancedStringSplit("RLLLLRRRLR"));
        Assert.assertEquals(1, new Solution().balancedStringSplit("LLLLRRRR"));
        Assert.assertEquals(0, new Solution().balancedStringSplit(""));
    }

    class Solution {
        public int balancedStringSplit(String s) {
            int count = 0;

            int balance = 0;
            for (char c : s.toCharArray()) {
                if (c == 'L') {
                    balance++;
                } else if (c == 'R') {
                    balance--;
                } else {
                    throw new IllegalArgumentException();
                }

                if (balance == 0) {
                    count++;
                }
            }

            return count;
        }
    }

    class Solution2 {
        public int balancedStringSplit(String s) {
            Stack<Character> stack = new Stack<>();
            int count = 0;
            for (char c : s.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else if (Objects.equals(c, stack.peek())) {
                    stack.push(c);
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        count++;
                    }
                }
            }

            return count;
        }
    }


}
