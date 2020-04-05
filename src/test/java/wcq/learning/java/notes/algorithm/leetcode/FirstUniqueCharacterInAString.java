package wcq.learning.java.notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/solution/zi-fu-chuan-zhong-de-di-yi-ge-wei-yi-zi-fu-by-leet/
 * <p>
 * 结题思路：遍历一遍字符串，把字符出现次数记录下来。再遍历一遍，找到第一个字符计数为1的字符。
 *
 * @author: wengchuqin
 * @create: 2020-04-05 17:46
 */
public class FirstUniqueCharacterInAString {
    @Test
    public void test() {
        Assert.assertEquals(0, new Solution().firstUniqChar("leetcode"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, new Solution().firstUniqChar("loveleetcode"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(-1, new Solution().firstUniqChar(""));
    }


    @Test
    public void test4() {
        Assert.assertEquals(-1, new Solution().firstUniqChar("lllcccc"));
    }

    class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Integer> map = new HashMap<>();
            char[] chars = s.toCharArray();
            for (char c : chars) {
                map.compute(c, (k, v) -> v == null ? 1 : v + 1);
            }

            for (int i = 0; i < chars.length; i++) {
                if (map.get(chars[i]) == 1) {
                    return i;
                }
            }

            return -1;
        }
    }
}
