package notes.algorithm.lcci.c04;

import notes.algorithm.leetcode.common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：合法二叉搜索树。实现一个函数，检查一棵二叉树是否为二叉搜索树。
 * https://leetcode-cn.com/problems/legal-binary-search-tree-lcci/
 *
 * 题解：假设二叉搜索树值不重复。那么使用中序遍历，结果就是一个递增序列。利用这个特性即可。
 *
 * @author: wengchuqin
 * @create: 2020-05-24 11:21
 */
public class LegalBinarySearchTreeLCCI {
    @Test
    public void test() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        Assert.assertTrue(new Solution().isValidBST(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(-1);

        Assert.assertFalse(new Solution().isValidBST(root));
    }


    @Test
    public void test3() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);


        Assert.assertFalse(new Solution().isValidBST(root));
    }


    @Test
    public void test4() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);


        Assert.assertFalse(new Solution().isValidBST(root));
    }


    @Test
    public void test5() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = null;
        root.left.right = null;
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);


        Assert.assertFalse(new Solution().isValidBST(root));
    }


    class Solution {
        public boolean isValidBST(TreeNode root) {
            return new Help(root).isValidBST();
        }


        /**
         * （1）使用中序遍历，把结果记录在数组中。
         * （2）检查数组是不是递增的。
         *
         *  改进思路：检查数组是不是递增的，只要检查前一个元素即可，所以不需要记录完整数组，是需要记录遍历过程中的前一个元素。
         */
        class Help {
            final List<Integer> vals;

            public Help(TreeNode root) {
                this.vals = new ArrayList<>();
                doValidBST(root);
            }

            public boolean isValidBST() {
                Integer pre = null;
                for (int val : vals) {
                    if (pre == null) {
                        pre = val;
                        continue;
                    }

                    if (val <= pre) {
                        return false;
                    }
                    pre = val;
                }

                return true;
            }


            public void doValidBST(TreeNode root) {
                if (root == null) {
                    return;
                }

                doValidBST(root.left);
                vals.add(root.val);
                doValidBST(root.right);
            }

        }
    }
}
