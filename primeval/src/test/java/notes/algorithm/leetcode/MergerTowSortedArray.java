package notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author: wengchuqin
 * @create: 2020-03-29 21:06
 */
public class MergerTowSortedArray {
    @Test
    public void test() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] num2 = new int[]{2, 5, 6};
        int n = 3;
        new Solution().merge(nums1, m, num2, n);

        Assert.assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);
    }

    @Test
    public void test2() {
        int[] nums1 = new int[]{1, 0};
        int m = 1;
        int[] num2 = new int[]{2};
        int n = 1;
        new Solution().merge(nums1, m, num2, n);

        Assert.assertArrayEquals(new int[]{1, 2}, nums1);
    }

    @Test
    public void test3() {
        int[] nums1 = new int[]{1, 2, 3, 0};
        int m = 3;
        int[] num2 = new int[]{2};
        int n = 1;
        new Solution().merge(nums1, m, num2, n);

        Assert.assertArrayEquals(new int[]{1, 2, 2, 3}, nums1);
    }


    @Test
    public void test4() {
        int[] nums1 = new int[]{1, 2, 3};
        int m = 3;
        int[] num2 = new int[]{};
        int n = 0;
        new Solution().merge(nums1, m, num2, n);

        Assert.assertArrayEquals(new int[]{1, 2, 3}, nums1);
    }

    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            for (int i = 0; i < m; i++) {
                nums1[m + n - i - 1] = nums1[m - i - 1];
            }
//            System.out.println("nums1: " + Arrays.toString(nums1));


            int n1 = n;
            int n2 = 0;
            for (int i = 0; i < m + n; i++) {
//                System.out.printf("i:%s, n1:%s, n2:%s, nums1:%s\n" , i, n1, n2, Arrays.toString(nums1));
                if (n1 == nums1.length) {
                    nums1[i] = nums2[n2];
                    n2++;
                } else if (n2 == nums2.length) {
                    nums1[i] = nums1[n1];
                    n1++;
                } else if (nums1[n1] < nums2[n2]) {
                    nums1[i] = nums1[n1];
                    n1++;
                } else {
                    nums1[i] = nums2[n2];
                    n2++;
                }
            }
        }
    }
}
