package wcq.learning.java.notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 题目：反转字符串
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons/275/string/1144/
 * <p>
 * 题解：双指针，头尾互换
 *
 * @author: wengchuqin
 * @create: 2020-04-05 18:00
 */
public class ReverseString {
    @Test
    public void test() {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        new Solution().reverseString(s);
        Assert.assertArrayEquals(new char[]{'o', 'l', 'l', 'e', 'h'}, s);
    }

    @Test
    public void test2() {
        char[] s = new char[]{'h'};
        new Solution().reverseString(s);
        Assert.assertArrayEquals(new char[]{'h'}, s);
    }

    @Test
    public void test3() {
        char[] s = new char[]{};
        new Solution().reverseString(s);
        Assert.assertArrayEquals(new char[]{}, s);
    }

    class Solution {
        public void reverseString(char[] s) {
            for (int i = 0, j = s.length - 1; i <= j; i++, j--) {
                change(s, i, j);
            }
        }

        public void change(char[] arr, int p1, int p2) {
            char tmp = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = tmp;
        }
    }
}
