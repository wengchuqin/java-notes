package notes.algorithm.lcci.c16;

import org.junit.Assert;
import org.junit.Test;

/**
 * 题目：编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 * https://leetcode-cn.com/problems/swap-numbers-lcci/
 *
 * @author: wengchuqin
 * @create: 2020-06-26 20:49
 */
public class SwapNumbersLCCI {
    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{2, 1},
                new Solution().swapNumbers(new int[]{1, 2}));
    }


    class Solution {
        /**
         * 1.将两数之和放入其中一个数；
         * 2.相互求差赋值便可。
         * <p>
         * a, b
         * a, b + a
         * b + a - a, b + a
         * b, b + a - b
         * b, a
         *
         * @param numbers
         * @return
         */
        public int[] swapNumbers(int[] numbers) {
            numbers[1] = numbers[0] + numbers[1];
            numbers[0] = numbers[1] - numbers[0];
            numbers[1] = numbers[1] - numbers[0];
            return numbers;
        }
    }
}
