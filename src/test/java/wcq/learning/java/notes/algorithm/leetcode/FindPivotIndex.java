package wcq.learning.java.notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wengchuqin
 * @create: 2020-03-22 21:13
 */
public class FindPivotIndex {
    @Test
    public void test() {
        Assert.assertEquals(3, new Solution().pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(-1, new Solution().pivotIndex(new int[]{1, 2, 3}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(0, new Solution().pivotIndex(new int[]{-1, -1, -1, 0, 1, 1}));
    }


    class Solution {
        public int pivotIndex(int[] nums) {

            int guessIndex = 0;
            int rightNum = 0;
            for (int i = 1; i < nums.length; i++) {
                rightNum += nums[i];
            }
            int leftNum = 0;

            while (guessIndex < nums.length) {
//                System.out.printf("leftNum:%s, rightNum:%s, guessIndex:%s\n", leftNum, rightNum, guessIndex);
                if (leftNum == rightNum) {
                    return guessIndex;
                }

                if (guessIndex == nums.length - 1) {
                    break;
                }
                leftNum += nums[guessIndex];
                rightNum -= nums[guessIndex + 1];
                guessIndex++;
            }

            return -1;
        }
    }
}
