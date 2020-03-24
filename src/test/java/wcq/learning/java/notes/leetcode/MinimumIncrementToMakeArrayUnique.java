package wcq.learning.java.notes.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 题目：https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/
 * 解题思路：将数组升序排序，扫描数组，如果发现A[i] <= A[i-1], 调整A[i] == A[i-1]+1
 *
 * @author: wengchuqin
 * @create: 2020-03-22 15:53
 */
public class MinimumIncrementToMakeArrayUnique {
    @Test
    public void test() {
        Assert.assertEquals(1, new Solution().minIncrementForUnique(new int[]{1, 2, 2}));
        Assert.assertEquals(6, new Solution().minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
        Assert.assertEquals(0, new Solution().minIncrementForUnique(new int[]{3}));
        Assert.assertEquals(0, new Solution().minIncrementForUnique(new int[]{3, 4, 5}));
        Assert.assertEquals(0, new Solution().minIncrementForUnique(new int[]{}));
    }

    class Solution {
        public int minIncrementForUnique(int[] A) {
            if (A.length == 0) {
                return 0;
            }

            Arrays.sort(A);

            int count = 0;
            for (int i = 1; i < A.length; i++) {
                int interval = A[i - 1] - A[i];
                if (interval >= 0) {
                    A[i] += (interval + 1);
                    count += (interval + 1);
                }
            }

            return count;
        }
    }
}
