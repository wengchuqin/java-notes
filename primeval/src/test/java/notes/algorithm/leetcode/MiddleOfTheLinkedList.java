package notes.algorithm.leetcode;

import notes.algorithm.leetcode.common.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


/**
 * 题目：链表的中间结点 https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *
 * @author: wengchuqin
 * @create: 2020-03-23 20:58
 */
public class MiddleOfTheLinkedList {
    @Test
    public void test() {
        ListNode node = ListNode.formList(Arrays.asList(1,2,3,4,5));
        System.out.println(node);

        ListNode middleNode = new Solution().middleNode(node);
        System.out.println(middleNode);
        Assert.assertEquals(Arrays.asList(3,4,5), ListNode.toList(middleNode));
    }

     @Test
    public void test2() {
        ListNode node = ListNode.formList(Arrays.asList(1,2,3,4,5,6));
        System.out.println(node);

        ListNode middleNode = new Solution().middleNode(node);
        System.out.println(middleNode);
         Assert.assertEquals(Arrays.asList(4,5,6), ListNode.toList(middleNode));
    }


     @Test
    public void test3() {
        ListNode node = ListNode.formList(Arrays.asList(1,2));
        System.out.println(node);

        ListNode middleNode = new Solution().middleNode(node);
        System.out.println(middleNode);
         Assert.assertEquals(Arrays.asList(2), ListNode.toList(middleNode));
    }




     @Test
    public void test4() {
        ListNode node = ListNode.formList(Arrays.asList(1));
        System.out.println(node);

        ListNode middleNode = new Solution().middleNode(node);
        System.out.println(middleNode);
         Assert.assertEquals(Arrays.asList(1), ListNode.toList(middleNode));
    }



     @Test
    public void test5() {
        ListNode node = null;
        System.out.println(node);

        ListNode middleNode = new Solution().middleNode(node);
        System.out.println(middleNode);
         Assert.assertNull(middleNode);
    }




    class Solution {
        public ListNode middleNode(ListNode head) {
            if (head == null) {
                return null;
            }

            ListNode p1 = head;
            ListNode p2 = head.next;

            while (p2 != null) {
                p1 = p1.next;

                p2 = p2.next;
                if (p2 == null) {
                    break;
                }
                p2 = p2.next;
            }
            return p1;
        }
    }
}
