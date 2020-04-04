package wcq.learning.java.notes.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 参考：https://www.geeksforgeeks.org/quick-sort/
 * @author: wengchuqin
 * @create: 2020-04-01 22:18
 */
public class QuickSort implements Sort {
    @Test
    public void test() {
        int arr[] = {12, 11, 13, 5, 6, 7};
        QuickSort ob = new QuickSort();
        ob.sort(arr);

        System.out.println(Arrays.toString(arr));
        Assert.assertArrayEquals(new int[]{5, 6, 7, 11, 12, 13}, arr);
    }

    @Test
    public void test2() {
        int arr[] = {1, 2, 3, 4, 5};
        QuickSort ob = new QuickSort();
        ob.sort(arr);

        System.out.println(Arrays.toString(arr));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }


    @Test
    public void test3() {
        int arr[] = {1};
        QuickSort ob = new QuickSort();
        ob.sort(arr);

        System.out.println(Arrays.toString(arr));
        Assert.assertArrayEquals(new int[]{1}, arr);
    }

    @Test
    public void test4() {
        int arr[] = {};
        QuickSort ob = new QuickSort();
        ob.sort(arr);

        System.out.println(Arrays.toString(arr));
        Assert.assertArrayEquals(new int[0], arr);
    }


    @Test
    public void test5() {
        int arr[] = {2, 1};
        QuickSort ob = new QuickSort();
        ob.sort(arr);

        System.out.println(Arrays.toString(arr));
        Assert.assertArrayEquals(new int[]{1, 2}, arr);
    }

    @Test
    public void test6() {
        int arr[] = {1, 2};
        QuickSort ob = new QuickSort();
        ob.sort(arr);

        System.out.println(Arrays.toString(arr));
        Assert.assertArrayEquals(new int[]{1, 2}, arr);
    }

    @Override
    public void sort(int arr[]) {
        quickSort(arr, 0, arr.length - 1);
    }

    void quickSort(int arr[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low; // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                // swap arr[i] and arr[j]
                change(arr, i, j);

                i++;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        change(arr, i, high);

        return i;
    }

    private void change(int[] arr, int p1, int p2) {
        int tmp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = tmp;
    }
}
