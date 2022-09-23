package com.goo.test.tree;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author Lenovo
 */
public class SymmetricTree {

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
        boolean res = isSymmetric(A);
        System.out.println(res);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        LinkedList<TreeNode> myQueue = new LinkedList<>();
        if (root.left != null) {
            myQueue.add(root.left);
        }
        if (root.right != null) {
            myQueue.add(root.right);
        }
        while (!myQueue.isEmpty()) {
            if (!curAndNextLevelIsSymmetric(myQueue)) {
                return false;
            }
        }
        return true;
    }

    public boolean curAndNextLevelIsSymmetric(LinkedList<TreeNode> myQueue) {
        if (myQueue.size() % 2 == 1) {
            return false;
        }
        LinkedList<TreeNode> temp = new LinkedList<>(myQueue);
        while (!myQueue.isEmpty()) {
            if (judge(myQueue.getFirst(),myQueue.getLast())){
                myQueue.removeFirst();
                myQueue.removeLast();
            }else {
                return false;
            }
        }
        myQueue.addAll(temp);
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
        return true;
    }

    public boolean judge(TreeNode node1, TreeNode node2) {
        boolean flag;
        if (node1.val != node2.val){return false;}
        if (node1.left != null && node2.right != null) {
            flag = node1.left.val == node2.right.val;
        } else if (node1.left == null && node2.right == null) {
            flag = true;
        }else {
            return false;
        }
        if (node1.right != null && node2.left != null) {
            flag = node1.right.val == node2.left.val;
        } else if (node1.right == null && node2.left == null) {
            flag = true;
        }else {
            return false;
        }

        return flag;
    }

}
