package notes.algorithm.leetcode.common;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    public static TreeNode formList(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        List<TreeNode> result = new ArrayList<>();
        result.add(new TreeNode(list.get(0)));
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == null) {
                continue;
            }

            int index = i - 1;
            TreeNode children = new TreeNode(list.get(i));
            if (index % 2 == 0) {
                result.get(index).left = children;
            } else {
                result.get(index).right = children;
            }
            result.add(i, children);
        }

        return result.get(0);
    }



}
