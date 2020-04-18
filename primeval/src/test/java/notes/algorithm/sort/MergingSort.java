package notes.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 参考：https://www.geeksforgeeks.org/merge-sort/
 *
 * @author: wengchuqin
 * @create: 2020-04-04 15:54
 */
public class MergingSort implements Sort {
    @Test
    public void test() {
        int arr[] = {12, 11, 13, 5, 6, 7};
        MergingSort ob = new MergingSort();
        ob.sort(arr);

        System.out.println(Arrays.toString(arr));
        Assert.assertArrayEquals(new int[]{5, 6, 7, 11, 12, 13}, arr);
    }

    @Test
    public void test2() {
        int arr[] = {1, 2, 3, 4, 5};
        MergingSort ob = new MergingSort();
        ob.sort(arr);

        System.out.println(Arrays.toString(arr));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }


    @Test
    public void test3() {
        int arr[] = {1};
        MergingSort ob = new MergingSort();
        ob.sort(arr);

        System.out.println(Arrays.toString(arr));
        Assert.assertArrayEquals(new int[]{1}, arr);
    }

    @Test
    public void test4() {
        int arr[] = {};
        MergingSort ob = new MergingSort();
        ob.sort(arr);

        System.out.println(Arrays.toString(arr));
        Assert.assertArrayEquals(new int[0], arr);
    }


    @Test
    public void test5() {
        int arr[] = {2, 1};
        MergingSort ob = new MergingSort();
        ob.sort(arr);

        System.out.println(Arrays.toString(arr));
        Assert.assertArrayEquals(new int[]{1, 2}, arr);
    }

    @Test
    public void test6() {
        int arr[] = {1, 2};
        MergingSort ob = new MergingSort();
        ob.sort(arr);

        System.out.println(Arrays.toString(arr));
        Assert.assertArrayEquals(new int[]{1, 2}, arr);
    }


    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}
