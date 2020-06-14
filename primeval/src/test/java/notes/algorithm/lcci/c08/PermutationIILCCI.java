package notes.algorithm.lcci.c08;

import org.junit.Test;

import java.util.*;

/**
 * 题目：无重复字符串的排列组合
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 * https://leetcode-cn.com/problems/permutation-i-lcci/
 *
 * @author: wengchuqin
 * @create: 2020-06-14 15:19
 */
public class PermutationIILCCI {
    @Test
    public void test() {
        System.out.println(Arrays.toString(new Solution().permutation("qqe")));
    }

    /**
     * 解法一：递归遍历所有可能
     */
    class Solution {
        public String[] permutation(String S) {
            Set<List<Character>> result = new Help(S).traversal().result();
            return result.stream().map(this::arrayToList).toArray(String[]::new);
        }

        private String arrayToList(List<Character> arr) {
            StringBuilder sb = new StringBuilder();
            for (Character n : arr) {
                sb.append(n);
            }
            return sb.toString();
        }

        class Help {
            private final List<Character> str;
            private final Set<List<Character>> result;

            public Help(String S) {
                this.str = arrayToList(S.toCharArray());
                this.result = new HashSet<>();
            }

            private Help traversal() {
                traversal(new ArrayList<>(), str);
                return this;
            }

            private void traversal(List<Character> s1, List<Character> s2) {
                for (int i = 0; i < s2.size(); i++) {
                    List<Character> tmpS1 = new ArrayList<>(s1);
                    tmpS1.add(s2.get(i));
                    List<Character> tmpS2 = new ArrayList<>(s2);
                    tmpS2.remove(i);
                    if (Objects.equals(tmpS1.size(), str.size())) {
                        result.add(tmpS1);
                    }
                    traversal(tmpS1, tmpS2);
                }
            }

            public Set<List<Character>> result() {
                return result;
            }

            private List<Character> arrayToList(char[] nums) {
                ArrayList<Character> tmp = new ArrayList<>(nums.length);
                for (Character n : nums) {
                    tmp.add(n);
                }
                return tmp;
            }


        }
    }
}
