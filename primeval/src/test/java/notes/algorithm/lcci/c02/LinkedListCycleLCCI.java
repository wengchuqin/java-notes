package notes.algorithm.lcci.c02;

import notes.algorithm.leetcode.common.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：给定一个有环链表，实现一个算法返回环路的开头节点。
 * 有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。
 * 题解一：暴力法，遍历链表，并把节点存到Set中如果存在相同节点，说明有环。
 * 题解二：快慢指针  //todo https://leetcode-cn.com/problems/linked-list-cycle-lcci/solution/kuai-man-zhi-zhen-python3-java-by-z1m/
 *
 * @author: wengchuqin
 * @create: 2020-05-13 23:16
 */
public class LinkedListCycleLCCI {
    @Test
    public void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        Assert.assertEquals(2, new Solution().detectCycle(n1).val);
    }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode p = head;
            Set<ListNode> set = new HashSet<>();
            while (p != null) {
                if (set.contains(p)) {
                    System.out.println("return: " + p.val);
                    return p;
                }
                System.out.printf("set.add(%s)\n", p.val);
                set.add(p);
                p = p.next;
            }
            return null;
        }
    }


}
