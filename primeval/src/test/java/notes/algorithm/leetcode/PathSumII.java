package notes.algorithm.leetcode;

import org.junit.Test;
import notes.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目：给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 https://leetcode-cn.com/problems/path-sum-ii/
 *
 * @author: wengchuqin
 * @create: 2020-03-23 23:24
 */
public class PathSumII {
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
        System.out.println(new Solution().pathSum(root, 7));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(
                4,
                null,
                null
        );
        System.out.println(new Solution().pathSum(root, 4));
    }

    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            return new Helper(root, sum).pathSum();
        }

        class Helper {
            final LinkedList<Integer> stack;
            final TreeNode root;
            final int sum;
            final List<List<Integer>> result;

            public Helper(TreeNode root, int sum) {
                this.root = root;
                this.sum = sum;
                this.stack = new LinkedList<>();
                this.result = new ArrayList<>();
            }

            public List<List<Integer>> pathSum() {
                iterate(root);
                return result;
            }

            private void iterate(TreeNode node) {
                if (node == null) {
                    return;
                }

                stack.addLast(node.val);

                iterate(node.left);
                iterate(node.right);

                System.out.printf("node:%s, stack:%s\n", node.val, stack);

                if (node.left == null && node.right == null) {  //叶子节点
                    Integer s = stack.stream().reduce(0, Integer::sum);
                    System.out.printf("叶子节点: node:%s, s:%s\n", node.val, s);
                    if (s == sum) {
                        result.add((List<Integer>) stack.clone());
                    }
                }

                stack.removeLast();
            }
        }
    }
}
