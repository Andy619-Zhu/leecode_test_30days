package com.goo.test.tree;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author Lenovo
 */
public class SumOfLeftLeaves {

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
        int res = sumOfLeftLeaves(A);

        System.out.println(res);

    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        LinkedList<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(root);
        int result = 0;
        while (!myQueue.isEmpty()) {
            result = result+sumOfCurLevelLeftLeaf(myQueue);
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
    public int sumOfCurLevelLeftLeaf(LinkedList<TreeNode> myQueue){
        int size = myQueue.size();
        int relult = 0;
        for (int i = 0; i < size; i++) {
            if (myQueue.get(i).left!=null&&myQueue.get(i).left.left==null&&myQueue.get(i).left.right==null){
                relult = relult+myQueue.get(i).left.val;
            }
        }
        return relult;
    }
}
