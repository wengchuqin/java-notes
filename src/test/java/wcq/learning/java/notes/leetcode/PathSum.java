package wcq.learning.java.notes.leetcode;

import org.junit.Assert;
import org.junit.Test;
import wcq.learning.java.notes.leetcode.common.TreeNode;

/**
 * 题目：https://leetcode-cn.com/problems/path-sum/
 *
 * @author: wengchuqin
 * @create: 2020-03-22 16:47
 */
public class PathSum {
    @Test
    public void test() {
        TreeNode root = new TreeNode(
                4,
                new TreeNode(
                        2,
                        new TreeNode(1, null, null),
                        new TreeNode(3, null, null)),
                new TreeNode(5, null, null)
        );

        Solution solution = new Solution();
        Assert.assertTrue(solution.hasPathSum(root, 7));
        Assert.assertTrue(solution.hasPathSum(root, 9));
        Assert.assertFalse(solution.hasPathSum(root, 10));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(
                1,
                null,
                null
        );

        Solution solution = new Solution();
        Assert.assertTrue(solution.hasPathSum(root, 1));
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(
                1,
                new TreeNode(
                        2,
                        null,
                        null
                ),
                null
        );

        Solution solution = new Solution();
        Assert.assertFalse(solution.hasPathSum(root, 1));
    }

    class Solution {
        public boolean hasPathSum(TreeNode root, int target) {
            if (root == null) {
                return false;
            }
            return iterate(root, 0, target);
        }

        public boolean iterate(TreeNode node, Integer sum, final int target) {
            if (node == null) {
                return false;
            }

            sum += node.val;
            if (node.left == null && node.right == null && sum == target) {
                return true;
            }


            return iterate(node.left, sum, target) ||
                    iterate(node.right, sum, target);
        }

    }
}
