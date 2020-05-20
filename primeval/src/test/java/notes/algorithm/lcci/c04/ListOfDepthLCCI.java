package notes.algorithm.lcci.c04;

import notes.algorithm.leetcode.common.ListNode;
import notes.algorithm.leetcode.common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目：给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 * https://leetcode-cn.com/problems/list-of-depth-lcci/
 * 题解：一层层遍历即可
 *
 * @author: wengchuqin
 * @create: 2020-05-19 22:45
 */
public class ListOfDepthLCCI {
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);

        root.left.left.left = new TreeNode(8);

        System.out.println(Arrays.toString(new Solution().listOfDepth(root)));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);

        System.out.println(Arrays.toString(new Solution().listOfDepth(root)));
    }

    class Solution {
        public ListNode[] listOfDepth(TreeNode tree) {
            if (tree == null) {
                return new ListNode[0];
            }

            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(tree);


            List<ListNode> result = new ArrayList<>();

            while (true) {
                result.add(change(queue));

                LinkedList<TreeNode> tmp = new LinkedList<>();
                while (!queue.isEmpty()) {
                    TreeNode node = queue.pop();

                    if (node.left != null) {
                        tmp.offer(node.left);
                    }
                    if (node.right != null) {
                        tmp.offer(node.right);
                    }
                }

                if (tmp.isEmpty()) {
                    break;
                }

                queue = tmp;
            }

            return result.toArray(new ListNode[0]);
        }

        ListNode change(LinkedList<TreeNode> list) {
            if (list == null || list.isEmpty()) {
                return null;
            }

            ListNode head = new ListNode(list.get(0).val);
            ListNode p = head;
            for (int i = 1; i < list.size(); i++) {
                ListNode tmp = new ListNode(list.get(i).val);
                p.next = tmp;
                p = tmp;
            }
            return head;
        }
    }
}
