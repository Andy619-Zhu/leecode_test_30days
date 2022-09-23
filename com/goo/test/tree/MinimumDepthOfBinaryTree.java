package com.goo.test.tree;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author Lenovo
 */
public class MinimumDepthOfBinaryTree {

    @Test
    public void test() {
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(3);
        TreeNode E = new TreeNode(4);
        TreeNode F = new TreeNode(4);
        TreeNode G = new TreeNode(3);
        TreeNode H = new TreeNode(8);
        TreeNode I = new TreeNode(8);
        A.left = B;
        A.right = C;
//        B.left = D;
//        B.right = E;
//        E.right = H;
//        D.right = I;
//        C.left = F;
//        C.right = G;
        int res = minDepth(A);
        System.out.println(res);
    }
    public int minDepth(TreeNode root) {
        LinkedList<TreeNode> myQueue = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        int result = 0;
        myQueue.add(root);
        while (!myQueue.isEmpty()) {
            boolean findFirstNode = calcLevelTree(myQueue);
            result++;
            if (findFirstNode){
                return result;
            }
        }
        return result;
    }

    public boolean calcLevelTree(LinkedList<TreeNode> myQueue) {
        int size = myQueue.size();
        for (int i = 0; i < size; i++) {
            TreeNode node = myQueue.get(0);
            if (node.left != null) {
                myQueue.add(node.left);
            }
            if (node.right != null) {
                myQueue.add(node.right);
            }
            if (isLeafNode(node)) {
                return true;
            }
            myQueue.remove(0);
        }
        return false;
    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
