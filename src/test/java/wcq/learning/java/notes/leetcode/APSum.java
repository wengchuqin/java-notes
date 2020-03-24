package wcq.learning.java.notes.leetcode;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 题目：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 题解：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/mian-shi-ti-57-ii-he-wei-sde-lian-xu-zheng-shu-x-2/
 *
 * @author: wengchuqin
 * @create: 2020-03-21 19:45
 */
public class APSum {
    private static final Logger logger = LoggerFactory.getLogger(WaterAndJugProblem.class);


    @Test
    public void test2() {
        Solution solution = new Solution();
        int[][] result = solution.findContinuousSequence(9);
        System.out.println(Arrays.deepToString(result));
    }


    @Test
    public void test3() {
        Solution solution = new Solution();
        int[][] result = solution.findContinuousSequence(15);
        System.out.println(Arrays.deepToString(result));
    }


    @Test
    public void test4() {
        Solution solution = new Solution();
        int[][] result = solution.findContinuousSequence(8);
        System.out.println(Arrays.deepToString(result));
    }


    private class Solution {
        public int[][] findContinuousSequence(int target) {
            List<Range> result = new ArrayList<>();
            int left = 1;
            int righ = 2;
            while (left < righ) {
                int sum = sum(left, righ);
                if (sum == target) {
                    result.add(new Range(left, righ));
                    righ++;
                } else if (sum < target) {
                    righ++;
                } else {
                    left++;
                }
            }
            return format(result);
        }


        int[][] format(List<Range> ranges) {
            return ranges
                    .stream()
                    .map(r -> IntStream.range(r.left, r.righ + 1).toArray())
                    .collect(Collectors.toList())
                    .toArray(new int[0][]);
        }

        class Range {
            int left;
            int righ;

            Range(int left, int righ) {
                this.left = left;
                this.righ = righ;
            }

            @Override
            public String toString() {
                return String.format("[%s, %s]", left, righ);
            }
        }

        /**
         * 求和公式
         *
         * @param left
         * @param righ
         * @return
         */
        public int sum(int left, int righ) {
            return ((left + righ) * (righ - left + 1)) / 2;
        }
    }
}
