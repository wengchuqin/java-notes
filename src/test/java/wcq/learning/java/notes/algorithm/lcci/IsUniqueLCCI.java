package wcq.learning.java.notes.algorithm.lcci;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：判定字符是否唯一  实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * https://leetcode-cn.com/problems/is-unique-lcci/
 * 题解一：把数组使用Set集合保存起来，判断是否有重复。
 * 题解二：如果字符串只包含字母，那么可以使用boolean[48]来代替Set集合。
 * 题解三：如果字符串只包含字母，那么可以使用Integer变量来代替Set集合（Integer有32个bit）。
 * 题解四：将字符数组排序，判断相邻两个是否重复。
 *
 * @author: wengchuqin
 * @create: 2020-04-06 22:39
 */
public class IsUniqueLCCI {
    @Test
    public void test() {
        Assert.assertFalse(new Solution().isUnique("leetcode"));
        Assert.assertTrue(new Solution().isUnique("abc"));
    }

    class Solution {
        public boolean isUnique(String astr) {
            Set<Character> set = new HashSet<>();
            for (char c : astr.toCharArray()) {
                if (set.contains(c)) {
                    return false;
                } else {
                    set.add(c);
                }
            }
            return true;
        }
    }
}
