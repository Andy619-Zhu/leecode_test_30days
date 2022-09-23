package com.goo.test.tree;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author Lenovo
 */
public class CountCompleteTreeNodes {


    @Test
    public void test(){
        TreeNode A = new TreeNode(3);
        TreeNode B = new TreeNode(9);
        TreeNode C = new TreeNode(20);
        TreeNode D = new TreeNode(15);
        TreeNode E = new TreeNode(7);
        TreeNode F = new TreeNode(6);
        TreeNode G = new TreeNode(7);
        TreeNode H = new TreeNode(8);
        A.left = B;
        A.right = C;
//        B.left = D;
//        B.right = E;
//        E.right = H;
        C.left = D;
        C.right = E;
        int res = countNodes(A);

        System.out.println(res);

    }

    public int countNodes(TreeNode root) {
        if (root==null){return 0;}
        LinkedList<TreeNode> myQueue = new LinkedList<>();
        int result = 0;
        myQueue.add(root);
        while (!myQueue.isEmpty()) {
            result = result+myQueue.size();
            calcLevelTree(myQueue);
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

    // 通用递归解法
    public int countNodes2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    /**
     * 针对完全二叉树的解法
     *
     * 满二叉树的结点数为：2^depth - 1
     */
    public int countNodes3(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth) {// 左子树是满二叉树
            // 2^leftDepth其实是 （2^leftDepth - 1） + 1 ，左子树 + 根结点
            return (1 << leftDepth) + countNodes(root.right);
        } else {// 右子树是满二叉树
            return (1 << rightDepth) + countNodes(root.left);
        }
    }

    private int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }


}
