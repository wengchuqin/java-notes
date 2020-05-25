package notes.algorithm.lcci.c04;

import notes.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
 * https://leetcode-cn.com/problems/check-subtree-lcci/
 * 题解：遍历两个课，把结果报错为l1，l2。检查l2是否包含l1；
 * @author: wengchuqin
 * @create: 2020-05-25 23:36
 */
public class CheckSubTreeLCCI {
    class Solution {
        public boolean checkSubTree(TreeNode t1, TreeNode t2) {
            List<Integer> l1 = new TraversalHelper(t1).traversal().result();
            List<Integer> l2 = new TraversalHelper(t2).traversal().result();
            return l1.containsAll(l2);
        }

        class TraversalHelper {
            private final List<Integer> result;
            private final TreeNode root;

            public TraversalHelper(TreeNode root) {
                this.root = root;
                this.result = new ArrayList<>();
            }

            public TraversalHelper traversal() {
                traversal(root);
                return this;
            }

            public void traversal(TreeNode node) {
                if (node == null) {
                    return;
                }

                traversal(node.left);
                result.add(node.val);
                traversal(node.right);
            }

            public List<Integer> result() {
                return result;
            }
        }
    }
}
