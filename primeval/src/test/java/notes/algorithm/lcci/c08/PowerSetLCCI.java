package notes.algorithm.lcci.c08;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 题目：幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 * 说明：解集不能包含重复的子集。
 * https://leetcode-cn.com/problems/power-set-lcci/
 *
 * @author: wengchuqin
 * @create: 2020-06-14 13:47
 */
public class PowerSetLCCI {
    @Test
    public void test1() {
        List<List<Integer>> result = new Solution().subsets(new int[]{1, 2, 3});
        System.out.println(result);
    }

    @Test
    public void test2() {
        List<List<Integer>> result = new Solution().subsets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10, 0});
        System.out.println(result);
    }


    /**
     * 使用位图来解
     * 例如 [1, 2, 3] 有三位可以从 0 遍历到 7 也就是 2 ^ 3 - 1 用二进制表示就是 000, 001, 010, 011, 100, 101, 110, 111 正好代表了全部子集。
     */
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> subsets = new ArrayList<>();

            int bmp = (int) Math.pow(2, nums.length);
            // 从 nums.length 个 0 遍历到 nums.length 个 1
            for (int result = 0; result < bmp; result++) {
                List<Integer> subset = new ArrayList<>();
                for (int i = 0; i < nums.length; i++) {
                    // 将每一位右移最低位，检测其是否为1
                    if ((result >>> i & 1) == 1) {
                        subset.add(nums[i]);
                    }
                }
                subsets.add(subset);
            }

            return subsets;
        }
    }

    class Solution2 {
        public List<List<Integer>> subsets(int[] nums) {
            Set<Set<Integer>> result = new Help(nums).traversal().result();
            result.add(new HashSet<>());
//            System.out.println(result);
            return result.stream().map(ArrayList::new).collect(Collectors.toList());
        }

        class Help {
            private final List<Integer> nums;
            private final Set<Set<Integer>> result;

            public Help(int[] nums) {
                this.nums = arrayToList(nums);
                this.result = new HashSet<>();
            }

            private Help traversal() {
                traversal(new HashSet<>(), nums);
                return this;
            }

            private void traversal(Set<Integer> s1, List<Integer> s2) {
                for (int i = 0; i < s2.size(); i++) {
                    Set<Integer> tmpS1 = new HashSet<>(s1);
                    tmpS1.add(s2.get(i));
                    List<Integer> tmpS2 = new ArrayList<>(s2);
                    tmpS2.remove(i);
                    result.add(tmpS1);
                    traversal(tmpS1, tmpS2);
                }
            }

            public Set<Set<Integer>> result() {
                return result;
            }

            private List<Integer> arrayToList(int[] nums) {
                ArrayList<Integer> tmp = new ArrayList<>(nums.length);
                for (int n : nums) {
                    tmp.add(n);
                }
                return tmp;
            }

        }
    }
}
