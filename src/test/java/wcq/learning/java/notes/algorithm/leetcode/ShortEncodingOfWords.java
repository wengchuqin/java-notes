package wcq.learning.java.notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 题目：单词的压缩编码 https://leetcode-cn.com/problems/short-encoding-of-words/
 *
 * @author: wengchuqin
 * @create: 2020-03-28 23:26
 */
public class ShortEncodingOfWords {
    @Test
    public void test() {
        Assert.assertEquals(10, new Solution().minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(5, new Solution().minimumLengthEncoding(new String[]{"time"}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(0, new Solution().minimumLengthEncoding(new String[]{}));
    }

    class Solution {
        public int minimumLengthEncoding(String[] words) {
            if (words.length == 0) {
                return 0;
            }

            String[] newWords = Arrays.stream(words)
                    .map(s -> new StringBuilder(s).reverse().toString())
                    .sorted()
                    .toArray(String[]::new);

            int sum = 0;
            for (int i = 1; i < newWords.length; i++) {
                if (!newWords[i].startsWith(newWords[i - 1])) {
                    sum = sum + newWords[i - 1].length() + 1;
                }
            }

            sum = sum + newWords[newWords.length - 1].length() + 1;

            return sum;
        }
    }
}
