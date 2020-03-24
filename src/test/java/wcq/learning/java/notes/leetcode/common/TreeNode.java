package wcq.learning.java.notes.leetcode.common;

/**
 * @author: wengchuqin
 * @create: 2020-03-22 16:48
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


}
