package notes.algorithm.lcci.c02;

import notes.algorithm.leetcode.common.ListNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * 题目：分割链表
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 * 题解：链表分为头尾两个部分，小于x的节点，插入头部。大于等于x的节点，插入尾部。
 *
 * @author: wengchuqin
 * @create: 2020-05-10 22:54
 */
public class PartitionListLCCI {
    @Test
    public void test() {
        ListNode list = ListNode.formList(Arrays.asList(3, 5, 8, 5, 10, 2, 1));
        ListNode partition = new Solution().partition(list, 5);
        System.out.println(partition.toString());
    }

    @Test
    public void test2() {
        ListNode list = ListNode.formList(Arrays.asList(3));
        ListNode partition = new Solution().partition(list, 5);
        System.out.println(partition.toString());
    }

    @Test
    public void test3() {
        ListNode list = ListNode.formList(Arrays.asList(1, 1));
        ListNode partition = new Solution().partition(list, 2);
        System.out.println(partition.toString());
    }

    @Test
    public void test4() {
        ListNode list = ListNode.formList(Arrays.asList(1, 4, 3, 2, 5, 2));
        ListNode partition = new Solution().partition(list, 3);
        System.out.println(partition.toString());
    }

    class Solution {
        public ListNode partition(ListNode node, int x) {
            if (node == null) {
                return null;
            }

            //初始化头尾节点
            ListNode head = new ListNode(node.val);
            ListNode tail = head;

            node = node.next;
            while (node != null) {
                ListNode tmp = new ListNode(node.val);
                if (node.val < x) {
                    //小于x的节点，插入头部
                    tmp.next = head;
                    head = tmp;
                } else {
                    //大于等于x的节点，插入尾部。
                    tail.next = tmp;
                    tail = tmp;
                }
                node = node.next;
            }
            return head;
        }
    }
}
