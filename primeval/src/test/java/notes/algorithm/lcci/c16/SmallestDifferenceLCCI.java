package notes.algorithm.lcci.c16;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * 题目：给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
 * https://leetcode-cn.com/problems/smallest-difference-lcci/
 *
 * @author: wengchuqin
 * @create: 2020-06-27 13:45
 */
public class SmallestDifferenceLCCI {
    @Test
    public void test() {
        Assert.assertEquals(3, new Solution().smallestDifference(
                new int[]{1, 3, 15, 11, 2},
                new int[]{23, 127, 235, 19, 8}
        ));
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, new Solution().smallestDifference(
                new int[]{-2147483648, 1},
                new int[]{2147483647, 0}
        ));
    }

    class Solution {
        /**
         * 将两个数组排序合并成一个数组。计算相邻的来源的两个值的差，取最小的。
         *
         * @param a
         * @param b
         * @return
         */
        public int smallestDifference(int[] a, int[] b) {
            LongNum[] nums = Stream.concat(
                    Arrays.stream(a).mapToObj(n -> new LongNum(n, "a")),
                    Arrays.stream(b).mapToObj(n -> new LongNum(n, "b")))
                    .sorted(Comparator.comparing(LongNum::getNum)).toArray(LongNum[]::new);


            long min = Integer.MAX_VALUE;
            for (int i = 1; i < nums.length; i++) {
                if (Objects.equals(nums[i - 1].source, nums[i].source)) {
                    continue;
                }
                long diff = Math.abs(nums[i - 1].num - nums[i].num);
                if (diff < min) {
                    min = diff;
                }
            }
            return (int) min;
        }

        class LongNum {
            long num;
            String source;

            public LongNum(int num, String source) {
                this.num = num;
                this.source = source;
            }

            public long getNum() {
                return num;
            }

            public String getSource() {
                return source;
            }

            @Override
            public String toString() {
                return "LongNum{" +
                        "num=" + num +
                        ", source='" + source + '\'' +
                        '}';
            }
        }
    }


    /**
     * 暴力法，性能不行 O(n^2)
     */
    class Solution2 {
        public int smallestDifference(int[] a, int[] b) {
            long min = Integer.MAX_VALUE;
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b.length; j++) {
                    long diff = Math.abs((long) a[i] - (long) b[j]);
                    if (diff < min) {
                        min = diff;
                    }
                }
            }
            return (int) min;
        }
    }
}
