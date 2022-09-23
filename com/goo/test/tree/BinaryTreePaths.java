package com.goo.test.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lenovo
 */
public class BinaryTreePaths {



    List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        preOrder(root, "");

        return result;
    }

    public void preOrder(TreeNode root, String s) {
        StringBuilder str = new StringBuilder(s);
        if (root == null) {
            return;
        }
        str.append(root.val);
        if (root.left == null && root.right == null) {
            result.add(str.toString());
        } else {
            str.append("->");
            preOrder(root.left, str.toString());
            preOrder(root.right, str.toString());
        }
    }
}
