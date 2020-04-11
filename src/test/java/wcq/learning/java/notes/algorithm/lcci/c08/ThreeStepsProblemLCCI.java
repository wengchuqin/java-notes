package wcq.learning.java.notes.algorithm.lcci.c08;

import org.junit.Assert;
import org.junit.Test;

/**
 * 题目：三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * @author: wengchuqin
 * @create: 2020-04-11 17:03
 */
public class ThreeStepsProblemLCCI {
    @Test
    public void test() {
        Assert.assertEquals(13, new Solution().waysToStep(5));
    }

    @Test
    public void test2() {
        Assert.assertEquals(752119970, new Solution().waysToStep(61));
    }


    @Test
    public void test3() {
        System.out.println(1000000007);
        System.out.println(Integer.MAX_VALUE);
    }


    class Solution {
        public int waysToStep2(int n) {
            if (n == 1) {
                return 1;
            } else if (n == 2) {
                return 2;
            } else if (n == 3) {
                return 4;
            }

            return waysToStep(n - 1)
                    + waysToStep(n - 2)
                    + waysToStep(n - 3);
        }

        public int waysToStep(int n) {
            long[] dp = new long[n + 3];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
                dp[i] %= 1000000007;
            }
            return (int) dp[n];

        }

    }
}
