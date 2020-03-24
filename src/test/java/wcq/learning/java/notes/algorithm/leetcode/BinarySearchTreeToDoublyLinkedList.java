package wcq.learning.java.notes.algorithm.leetcode;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 *
 * @author: wengchuqin
 * @create: 2020-03-21 20:32
 */
public class BinarySearchTreeToDoublyLinkedList {
    private static final Logger logger = LoggerFactory.getLogger(BinarySearchTreeToDoublyLinkedList.class);

    @Test
    public void test() {
        Node root = new Node(
                4,
                new Node(
                        2,
                        new Node(1, null, null),
                        new Node(3, null, null)),
                new Node(5, null, null)
        );

        Solution solution = new Solution();
        Node head = solution.treeToDoublyList(root);
        System.out.println(head);
    }

    @Test
    public void test2() {
        Node root = null;

        Solution solution = new Solution();
        Node head = solution.treeToDoublyList(root);
        System.out.println(head);
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;


        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    private static class Solution {


        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }

            Helper helper = new Helper(root);
            //遍历所有节点
            helper.iterator(root);

            //收尾相连
            helper.head.left = helper.pre;
            helper.pre.right = helper.head;

            return helper.head;
        }


        /**
         * 使用中序遍历，这样就能从小到大遍历节点了。
         */
        private class Helper {
            final Node root;
            Node pre;
            Node head;

            public Helper(Node root) {
                this.root = root;
            }

            void iterator(Node cur) {
                if (cur == null) {
                    return;
                }
                iterator(cur.left);

//                logger.info("{} ", cur.val);


                if (pre == null) {
                    pre = cur;
                    head = cur;
                } else {
                    pre.right = cur;
                    cur.left = pre;
                    pre = cur;
                }

                iterator(cur.right);
            }
        }
    }


}
