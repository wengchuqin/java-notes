package wcq.learning.java.notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 题目：https://leetcode-cn.com/problems/task-scheduler/
 *
 * @author: wengchuqin
 * @create: 2020-03-22 18:54
 */
public class TaskScheduler {
    @Test
    public void test() {
        Assert.assertEquals(8, new Solution().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        Assert.assertEquals(10, new Solution().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 3));
    }

    @Test
    public void test2() {
        Assert.assertEquals(52, new Solution().leastInterval(new char[]{'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E', 'F', 'F', 'G', 'G', 'H', 'H', 'I', 'I', 'J', 'J', 'K', 'K', 'L', 'L', 'M', 'M', 'N', 'N', 'O', 'O', 'P', 'P', 'Q', 'Q', 'R', 'R', 'S', 'S', 'T', 'T', 'U', 'U', 'V', 'V', 'W', 'W', 'X', 'X', 'Y', 'Y', 'Z', 'Z'},
                2));
    }


    @Test
    public void test3() {
        Assert.assertEquals(8, new Solution().leastInterval(new char[]{'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D'},
                1));
    }


    class Solution {
        public int leastInterval(char[] tasks, int n) {
            int interval = n + 1;

            Map<Character, Integer> countMap = new LinkedHashMap<>();
            for (char c : tasks) {
                countMap.compute(c, (k, v) -> v == null ? 1 : ++v);
            }

            System.out.println("countMap: " + countMap);

            int count = 0;
            while (!countMap.isEmpty()) {
                countMap = sortMapByValue(countMap);
                Iterator<Map.Entry<Character, Integer>> iterator = countMap.entrySet().iterator();
                for (int i = 0; i < n && !countMap.isEmpty(); i++) {
                    count++;
                    if (!iterator.hasNext()) {
                        continue;
                    }
                    Map.Entry<Character, Integer> entry = iterator.next();
//                    entry.setValue(entry.getValue() - 1);
                }

            }

            return 0;
        }

        private Map<Character, Integer> sortMapByValue(Map<Character, Integer> input) {
            return input.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        }
    }

    class Solution2 {
        public int leastInterval(char[] tasks, int n) {
            n += 1;

            Map<Character, Integer> countMap = new LinkedHashMap<>();
            for (char c : tasks) {
                countMap.compute(c, (k, v) -> v == null ? 1 : ++v);
            }

            System.out.println("countMap: " + countMap);

            Set<CharCnt> remain = new TreeSet<>(new Comparator<CharCnt>() {
                @Override
                public int compare(CharCnt o1, CharCnt o2) {
                    return Comparator.comparing(CharCnt::getC)
                            .thenComparing(CharCnt::getC)
                            .compare(o1, o2);
                }
            });
            countMap.forEach((key, value) -> remain.add(new CharCnt(key, value)));

            int count = 0;
            while (!remain.isEmpty()) {
                Iterator<CharCnt> iterator = remain.iterator();
                for (int i = 0; i < n; i++) {
                    if (remain.isEmpty()) {
                        break;
                    }
                    count++;
                    System.out.println("remain: " + remain);
                    if (!iterator.hasNext()) {
                        continue;
                    }
                    CharCnt charCnt = iterator.next();
                    charCnt.cnt--;
                    if (charCnt.cnt == 0) {
                        iterator.remove();
                    }
                }
            }

            return count;
        }


        class CharCnt {
            char c;
            int cnt;

            public CharCnt(char c, int cnt) {
                this.c = c;
                this.cnt = cnt;
            }


            public char getC() {
                return c;
            }

            public int getCnt() {
                return cnt;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                CharCnt charCnt = (CharCnt) o;
                return c == charCnt.c;
            }

            @Override
            public int hashCode() {
                return Objects.hash(c);
            }

            @Override
            public String toString() {
                return String.format("%s:%s", c, cnt);
            }
        }
    }


}
