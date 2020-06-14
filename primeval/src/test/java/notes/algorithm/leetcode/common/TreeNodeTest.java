package notes.algorithm.leetcode.common;

import org.junit.Test;

import java.util.Arrays;

public class TreeNodeTest {
    @Test
    public void test() {
        TreeNode treeNode = TreeNode.formList(Arrays.asList(5, 3, 6, 2, 4, null, null, 1));
        System.out.println(treeNode);
    }

}