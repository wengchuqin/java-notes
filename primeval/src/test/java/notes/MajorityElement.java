package notes;

import org.junit.Assert;
import org.junit.Test;

/**
 * 题目：给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * https://leetcode-cn.com/problems/majority-element/
 *
 * @author: wengchuqin
 * @create: 2020-03-25 23:01
 */
public class MajorityElement {
    @Test
    public void test() {
        Assert.assertEquals(3, new Solution().majorityElement(new int[]{3, 2, 3}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, new Solution().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(3, new Solution().majorityElement(new int[]{3}));
    }


    /**
     * 如果我们把众数记为 +1，把其他数记为 −1，将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多。
     */
    class Solution {
        public int majorityElement(int[] nums) {
            int candidate = Integer.MAX_VALUE;
            int count = 0;

            for (int n : nums) {
                if (count == 0) {
                    candidate = n;
                    count++;
                    continue;
                }


                if (n == candidate) {
                    count++;
                } else {
                    count--;
                }
            }

            return candidate;
        }
    }
}
