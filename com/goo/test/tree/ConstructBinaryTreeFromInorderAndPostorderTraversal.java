package com.goo.test.tree;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Lenovo
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    @Test
    public void test() {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode res = buildTree(inorder, postorder);
        System.out.println(res);

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode result = new TreeNode(postorder[postorder.length - 1]);

        while (inorder.length > 1 || postorder.length > 1) {
            int[] index = splitTree(inorder, postorder);
            result = updateTree(result, postorder[index[0]], postorder[index[1]]);
            inorder = Arrays.copyOfRange(inorder, 0, index[0] + 1);
            postorder = Arrays.copyOfRange(postorder, 0, index[0] + 1);
        }
        return result;
    }

    public int[] splitTree(int[] inorderSub, int[] postorderSub) {
        int[] resIndex = {0, 0};
        int rootSub = postorderSub[postorderSub.length - 1];
        for (int index = 0; index < inorderSub.length; index++) {
            if (rootSub == inorderSub[index]) {
                resIndex[0] = index - 1;
                resIndex[1] = postorderSub.length > 1 ? postorderSub.length - 2 : 0;
                return resIndex;
            }
        }
        return resIndex;
    }

    public TreeNode updateTree(TreeNode root, int leftVal, int rightVal) {
        TreeNode left = new TreeNode(leftVal);
        TreeNode right = new TreeNode(rightVal);
        root.left = left.val == 0 ? null : left;
        root.right = right.val == 0 ? null : right;
        return root;
    }
}
