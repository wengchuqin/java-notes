package wcq.learning.java.notes.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author: wengchuqin
 * @create: 2020-04-01 22:18
 */
public class QuickSort {
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

    public void sort(int arr[]) {
        quickSort(arr, 0, arr.length);
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int q = partition(arr, start, end);
            quickSort(arr, start, q);
            quickSort(arr, q + 1, end);
        }
    }

    /**
     * 把数组分成两部分，左边部分的值 比 右边部分的值 小。 返回中标。
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private int partition(int[] arr, int start, int end) {
        int p = end - 1;
        int p1 = start;
        int p2 = start;
        while (p2 < p) {
            if (arr[p2] < arr[p]) {
                change(arr, p1, p2);
                p1++;
                p2++;
            } else {
                p2++;
            }
        }
        change(arr, p1, p);
        return p1;
    }

    private void change(int[] arr, int p1, int p2) {
        int tmp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = tmp;
    }
}
