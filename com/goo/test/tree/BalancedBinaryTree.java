package com.goo.test.tree;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author Lenovo
 */
public class BalancedBinaryTree {

    @Test
    public void test() {
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(2);
        TreeNode D = new TreeNode(3);
        TreeNode E = new TreeNode(3);
        TreeNode F = new TreeNode(3);
        TreeNode G = new TreeNode(3);
        TreeNode H = new TreeNode(4);
        TreeNode I = new TreeNode(4);
        TreeNode J = new TreeNode(4);
        TreeNode K = new TreeNode(4);
        TreeNode L = new TreeNode(4);
        TreeNode M = new TreeNode(4);
        TreeNode N = new TreeNode(5);
        TreeNode O = new TreeNode(5);
        TreeNode P = new TreeNode(4);

//        A.left = B;
        A.right = C;
//        B.left = D;
//        B.right = E;
//        C.left = F;
        C.right = G;
//        D.left = H;
//        D.right = I;
//        E.left = J;
//        E.right = K;
//        F.left = L;
//        F.right = M;
//        H.left = N;
//        H.right = O;
        boolean res = isBalanced(A);

        System.out.println(res);

    }


    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> myQueue1 = new LinkedList<>();

        myQueue1.add(root);
        while (!myQueue1.isEmpty()) {
            for (TreeNode node : myQueue1) {
                int leftDepth = maxLeftDepth(node);
                int rightDepth = maxRightDepth(node);
                if (Math.abs(leftDepth - rightDepth) > 1) {
                    return false;
                }
            }
            calcLevelTree(myQueue1);
        }

        return true;
    }


    public int maxLeftDepth(TreeNode root) {
        if (root.left == null){return 1;}
        LinkedList<TreeNode> myQueue = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        int result = 1;
        myQueue.add(root.left);
        while (!myQueue.isEmpty()) {
            calcLevelTree(myQueue);
            result++;
        }
        return result;
    }

    public int maxRightDepth(TreeNode root) {
        if (root.right == null){return 1;}
        LinkedList<TreeNode> myQueue = new LinkedList<>();

        if (root == null) {
            return 0;
        }
        int result = 1;

        myQueue.add(root.right);
        while (!myQueue.isEmpty()) {
            calcLevelTree(myQueue);
            result++;
        }
        return result;
    }

    public void calcLevelTree(LinkedList<TreeNode> myQueue) {
        int size = myQueue.size();
        for (int i = 0; i < size; i++) {
            TreeNode node = myQueue.get(0);
            if (node.left != null) {
                myQueue.add(node.left);
            }
            if (node.right != null) {
                myQueue.add(node.right);
            }
            myQueue.remove(0);
        }
    }
}
