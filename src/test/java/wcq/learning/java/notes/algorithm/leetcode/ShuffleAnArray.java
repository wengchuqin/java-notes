package wcq.learning.java.notes.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static wcq.learning.java.notes.algorithm.sort.Helper.change;

/**
 * 题目：打乱数组 https://leetcode-cn.com/problems/shuffle-an-array/
 * 题解一：旧数组随机删除一个元素，并把删除的元素加到新数组中
 * 题解二：Fisher-Yates 洗牌算法：从0开始迭代（至末尾），随机与后面的元素进行交换
 *
 * @author: wengchuqin
 * @create: 2020-04-06 15:21
 */
public class ShuffleAnArray {
    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        System.out.println(Arrays.toString(new Solution(nums).shuffle()));
        System.out.println(Arrays.toString(new Solution(nums).shuffle()));
        System.out.println(Arrays.toString(new Solution(nums).reset()));
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 3};
        System.out.println(Arrays.toString(new Solution2(nums).shuffle()));
        System.out.println(Arrays.toString(new Solution2(nums).shuffle()));
        System.out.println(Arrays.toString(new Solution2(nums).reset()));
    }


    class Solution {
        final int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return nums.clone();
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            List<Integer> newList = new LinkedList<>();
            List<Integer> oldList = new LinkedList<>();
            for (int n : nums) {
                oldList.add(n);
            }

            for (int i = 0; i < nums.length; i++) {
                Random random = new Random();
                Integer n = oldList.remove(random.nextInt(oldList.size()));
                newList.add(n);
            }

            return newList.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    class Solution2 {
        final int[] nums;

        public Solution2(int[] nums) {
            this.nums = nums;
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return nums.clone();
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            int[] shuffle = nums.clone();
            for (int i = 0; i < nums.length; i++) {
                change(shuffle, i, random(i, nums.length));
            }
            return shuffle;
        }

        private int random(int start, int end) {
            return new Random().nextInt(end - start) + start;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
}
