package notes.algorithm.lcci.c04;

import notes.algorithm.leetcode.common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目：首个共同祖先。设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。
 * 题解：遍历整棵树，记录父子映射关系。然后根据父子映射关系，找到p和q的祖先列表。p和q的祖先列表的相同节点即为共同祖先。
 *
 * @author: wengchuqin
 * @create: 2020-05-24 23:08
 */
public class FirstCommonAncestorLCCI {
    @Test
    public void test1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);


        Assert.assertEquals(3,
                new Solution().lowestCommonAncestor(
                        root,
                        root.left,
                        root.right
                ).val
        );
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);


        Assert.assertEquals(5,
                new Solution().lowestCommonAncestor(
                        root,
                        root.left,
                        root.left.left
                ).val
        );
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);


        Assert.assertEquals(3,
                new Solution().lowestCommonAncestor(
                        root,
                        root.left.left,
                        root.right.right
                ).val
        );
    }

    class Solution {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return new Help(root, p, q).lowestCommonAncestor();
        }

        class Help {
            TreeNode root;
            TreeNode p;
            TreeNode q;

            Map<TreeNode, TreeNode> childParenMap;

            public Help(TreeNode root, TreeNode p, TreeNode q) {
                this.root = root;
                this.p = p;
                this.q = q;
                this.childParenMap = new HashMap<>();
            }

            public TreeNode lowestCommonAncestor() {
                traversal(root, null);
//                System.out.println("childParenMap: " + childParenMap);
                List<TreeNode> pAncestorList = findAncestor(p, childParenMap);
                List<TreeNode> qAncestorList = findAncestor(q, childParenMap);
                return lowestCommonAncestor(pAncestorList, qAncestorList);
            }

            /**
             * 查询祖先，包括自己
             *
             * @param p
             * @param childParenMap
             * @return
             */
            private List<TreeNode> findAncestor(TreeNode p, Map<TreeNode, TreeNode> childParenMap) {
                TreeNode tmp = p;
                List<TreeNode> ancestorList = new ArrayList<>();
                while (tmp != null) {
                    ancestorList.add(tmp);
                    tmp = childParenMap.get(tmp);
                }
                return ancestorList;
            }

            private TreeNode lowestCommonAncestor(List<TreeNode> pa, List<TreeNode> qa) {
                for (TreeNode p : pa) {
                    for (TreeNode q : qa) {
                        if (p.val == q.val) {
                            return p;
                        }
                    }
                }
                return null;
            }


            void traversal(TreeNode cur, TreeNode parent) {
                if (cur == null) {
                    return;
                }
                childParenMap.put(cur, parent);
                traversal(cur.left, cur);
                traversal(cur.right, cur);
            }

        }
    }


}
