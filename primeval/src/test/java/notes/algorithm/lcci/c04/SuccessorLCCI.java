package notes.algorithm.lcci.c04;

import notes.algorithm.leetcode.common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 题目：后继者。设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。如果指定节点没有对应的“下一个”节点，则返回null。
 * https://leetcode-cn.com/problems/successor-lcci/
 * 题解：使用中序遍历，遍历所有节点。并且把上一个节点记录下来，发现上一节点为题目指定的节点，那么当前节点就是后继者。
 *
 * @author: wengchuqin
 * @create: 2020-05-24 13:28
 */
public class SuccessorLCCI {


    @Test
    public void test() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);


        Assert.assertEquals(2, new Solution().inorderSuccessor(root, new TreeNode(1)).val);
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        Assert.assertEquals(null, new Solution().inorderSuccessor(root, new TreeNode(6)));
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        Assert.assertEquals(null, new Solution().inorderSuccessor(root, new TreeNode(6)));
    }


    @Test
    public void test4() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        Assert.assertEquals(2, new Solution().inorderSuccessor(root, new TreeNode(1)).val);
    }

    @Test
    public void test5() {
        TreeNode root = new TreeNode(2);
        root.left = null;
        root.right = new TreeNode(3);

        Assert.assertEquals(3, new Solution().inorderSuccessor(root, new TreeNode(2)).val);
    }

    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            return new Help(root, p).inorderSuccessor();
        }

        class Help {
            TreeNode result;
            TreeNode pre;

            public Help(TreeNode root, TreeNode p) {
                pre = null;
                traversal(root, null, p);
            }

            void traversal(TreeNode cur, TreeNode parent, TreeNode target) {
                if (cur == null) {
                    return;
                }
                if (target == null) {
                    return;
                }
                if (result != null) {
                    return;
                }

                traversal(cur.left, pre, target);

//                System.out.printf("cur:%s, pre:%s, target:%s\n", cur.val, pre == null ? null : pre.val, target.val);

                if (pre != null && pre.val == target.val && result == null) {
                    result = cur;
//                    System.out.println("result == cur == " + cur.val);
                    return;
                }
                pre = cur;

                traversal(cur.right, pre, target);
            }

            TreeNode inorderSuccessor() {
                return result;
            }
        }
    }
}
