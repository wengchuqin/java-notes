package notes.algorithm.lcci.c10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 题目：编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * https://leetcode-cn.com/problems/group-anagrams-lcci/
 *
 * @author: wengchuqin
 * @create: 2020-06-26 18:13
 */
public class GroupAnagramsLCCI {
    @Test
    public void test() {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new Solution().groupAnagrams(strs));
    }

    class Solution {
        /**
         * 解法："变位词" 排序后，是相同的。通过Map，把排序后的值作为key，value则是原始值。
         *
         * @param strs
         * @return
         */
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<List<Character>, List<String>> result = new HashMap<>();
            for (String str : strs) {
                List<Character> tmp = str.chars().mapToObj(c -> (char) c).sorted().collect(Collectors.toList());
                result.computeIfAbsent(tmp, x -> new ArrayList<>()).add(str);
            }
            return new ArrayList<>(result.values());
        }
    }
}
