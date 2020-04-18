package notes.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static notes.algorithm.sort.Helper.change;

/**
 * Java program for implementation of Heap Sort
 * 参考: https://www.geeksforgeeks.org/heap-sort/
 *
 * @author: wengchuqin
 * @create: 2020-03-24 13:03
 */
public class HeapSort implements Sort{
    @Test
    public void test() {
        int arr[] = {12, 11, 13, 5, 6, 7};
        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println(Arrays.toString(arr));
        Assert.assertArrayEquals(new int[]{5, 6, 7, 11, 12, 13}, arr);
    }

    @Override
    public void sort(int arr[]) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            change(arr, 0, i);

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is an index in arr[].
    // n is size of heap
    void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {

            change(arr, i, largest);

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

}
