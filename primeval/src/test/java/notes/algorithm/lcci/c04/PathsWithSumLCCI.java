package notes.algorithm.lcci.c04;

import notes.algorithm.leetcode.common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 题目：求和路径 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 * https://leetcode-cn.com/problems/paths-with-sum-lcci/
 *
 * @author: wengchuqin
 * @create: 2020-05-28 23:27
 */
public class PathsWithSumLCCI {
    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);


        int count = new Solution().new SumHelp(root, 22).count();
        System.out.println(count);

        Assert.assertEquals(3, new Solution().pathSum(root, 22));
    }


    @Test
    public void test2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);


        Assert.assertEquals(3, new Solution().pathSum(root, 22));
    }


    @Test
    public void test3() {
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);

        Assert.assertEquals(1, new Solution().pathSum(root, -5));
    }


    @Test
    public void test4() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(-2);

        root.left.left.left = new TreeNode(-1);


        Assert.assertEquals(4, new Solution().pathSum(root, -1));

    }

    class Solution {
        public int pathSum(TreeNode root, int sum) {
            return new TraversalHelp(root, sum).pathSum();
        }

        /**
         * 递归遍历root树所有节点，计算以当前节点为根节点的子树 节点数值总和等于某个给定值的所有路径的数量。
         */
        class TraversalHelp {
            private final TreeNode root;
            private final int target;
            private int count = 0;


            public TraversalHelp(TreeNode root, int target) {
                this.root = root;
                this.target = target;
            }

            public int pathSum() {
                traversal(root);
                return count;
            }

            void traversal(TreeNode node) {
                if (node == null) {
                    return;
                }

                count += new SumHelp(node, target).count();
                traversal(node.left);
                traversal(node.right);
            }

        }


        /**
         * 计算以root为根节点，节点数值总和等于target的所有路径的数量
         * 实现：已root为起点，递归遍历每条路径的和，如果和等于target，则count++；
         */
        class SumHelp {
            private final TreeNode root;
            private final int target;
            private int count = 0;

            public SumHelp(TreeNode root, int target) {
                this.root = root;
                this.target = target;
            }

            public int count() {
//                System.out.println("SumHelp count()");
                traversal(0, root);
                return count;
            }

            private void traversal(int total, TreeNode node) {
                if (node == null) {
                    return;
                }

                total += node.val;
//                System.out.printf("traversal node:%s, total:%s\n", node.val, total);

                if (total == target) {
                    count++;
//                    System.out.println("count++  -> " + count);
                }

                traversal(total, node.left);
                traversal(total, node.right);
            }

        }
    }
}
