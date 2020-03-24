package wcq.learning.java.notes.leetcode;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: wengchuqin
 * @create: 2020-03-21 23:28
 */
public class ValidPerfectSquare {
    private static final Logger logger = LoggerFactory.getLogger(ValidPerfectSquare.class);

    class Solution {
        public boolean isPerfectSquare(int num) {
            if (num < 2) {
                return true;
            }

            long left = 2;
            long right = num;

            while (left <= right) {
                long mid = (right + left) / 2;
                long guessSquared = mid * mid;
                if (guessSquared == num) {
                    return true;
                } else if (guessSquared < num) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

                logger.info("left:{}, right:{}", left, right);
            }
            return false;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
//        Assert.assertTrue(s.isPerfectSquare(4));
//        Assert.assertTrue(s.isPerfectSquare(0));
//        Assert.assertTrue(s.isPerfectSquare(16));
//        Assert.assertFalse(s.isPerfectSquare(14));
//        Assert.assertFalse(s.isPerfectSquare(3));
//        Assert.assertTrue(s.isPerfectSquare(1));
        Assert.assertTrue(s.isPerfectSquare(Integer.MAX_VALUE));
    }
}
