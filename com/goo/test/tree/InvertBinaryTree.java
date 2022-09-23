package com.goo.test.tree;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author Lenovo
 */
public class InvertBinaryTree {

    @Test
    public void test() {
        TreeNode A = new TreeNode(4);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(7);
        TreeNode D = new TreeNode(1);
        TreeNode E = new TreeNode(3);
        TreeNode F = new TreeNode(6);
        TreeNode G = new TreeNode(9);
        TreeNode H = new TreeNode(8);
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
//        E.right = H;
        C.left = F;
        C.right = G;
        TreeNode res = invertTree(A);
        System.out.println(res);
    }


    public TreeNode invertTree(TreeNode root) {
        if (root == null){return null;}
        LinkedList<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(root);
        while (!myQueue.isEmpty()) {
            invertCurTree(myQueue.getFirst());
            if (myQueue.getFirst().left != null) {
                myQueue.add(myQueue.getFirst().left);
            }
            if (myQueue.getFirst().right != null) {
                myQueue.add(myQueue.getFirst().right);
            }
            myQueue.removeFirst();
        }
        return root;
    }

    public TreeNode invertCurTree(TreeNode curNode) {
        if (curNode.left != null || curNode.right != null) {
            TreeNode tempNode = curNode.left != null ? curNode.left : null;
            curNode.left = curNode.right != null ? curNode.right : null;
            curNode.right = tempNode;
        }
        return curNode;
    }
}
