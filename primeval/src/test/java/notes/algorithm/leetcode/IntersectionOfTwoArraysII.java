package notes.algorithm.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 题目：给定两个数组，编写一个函数来计算它们的交集。
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * <p>
 * 题解一：使用num1转换成Hash表，遍历num2的元素，检查是否在Hash表存在
 * 题解二：排序，然后使用双指针
 *
 * @author: wengchuqin
 * @create: 2020-04-06 16:30
 */
public class IntersectionOfTwoArraysII {

    @Test
    public void test() {
        System.out.println(Arrays.toString(new Solution().intersect(
                new int[]{1, 2, 2, 1},
                new int[]{2, 2}
        )));
    }

    @Test
    public void test2() {
        System.out.println(Arrays.toString(new Solution().intersect(
                new int[]{4, 9, 5},
                new int[]{9, 4, 9, 8, 4}
        )));
    }

    @Test
    public void test3() {
        System.out.println(Arrays.toString(new Solution().intersect(
                new int[]{},
                new int[]{}
        )));
    }


    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map1 = new HashMap<>(nums1.length);
            for (int n : nums1) {
                map1.compute(n, (k, v) -> v == null ? 1 : v + 1);
            }

            List<Integer> result = new LinkedList<>();

            for (int n : nums2) {
                Integer count = map1.getOrDefault(n, 0);
                if (count == 0) {
                    continue;
                } else {
                    result.add(n);
                    map1.put(n, count - 1);
                }
            }

            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
