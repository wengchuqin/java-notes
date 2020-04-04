package wcq.learning.java.notes.algorithm.sort;

/**
 * @author: wengchuqin
 * @create: 2020-04-04 16:59
 */
public class Helper {
    public static void change(int[] arr, int p1, int p2) {
        int tmp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = tmp;
    }
}
