package notes.algorithm.leetcode.common;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: wengchuqin
 * @create: 2020-03-23 20:58
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return toList(this).stream().map(String::valueOf).collect(Collectors.joining(" -> "));
    }


    public static ListNode formList(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        ListNode head = new ListNode(list.get(0));
        ListNode p = head;
        for (int i = 1; i < list.size(); i++) {
            ListNode tmp = new ListNode(list.get(i));
            p.next = tmp;
            p = tmp;
        }
        return head;
    }

    public static List<Integer> toList(ListNode node) {
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list;
    }
}
