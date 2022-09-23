package com.goo.test.tree;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author Lenovo
 */
public class FindBottomLeftTreeValue {

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
        int res = findBottomLeftValue(P);

        System.out.println(res);

    }

    int result = Integer.MAX_VALUE;

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(root);
        while (!myQueue.isEmpty()) {

            calcLevelTree(myQueue);
        }
        return result == Integer.MAX_VALUE ? root.val : result;
    }

    public void calcLevelTree(LinkedList<TreeNode> myQueue) {
        int size = myQueue.size();
        for (int i = 0; i < size; i++) {
            TreeNode node = myQueue.getFirst();
            if (node.left != null) {
                myQueue.add(node.left);
            }
            if (node.right != null) {
                myQueue.add(node.right);
            }
            myQueue.removeFirst();
        }
        if (judgeLastLevel(myQueue)){
            result = myQueue.getFirst().val;
        }

    }
    public boolean judgeLastLevel(LinkedList<TreeNode> myQueue) {
        if (myQueue.size()==0){return false;}
        for (TreeNode node : myQueue) {
            if (node.left!=null||node.right!=null){
                return false;
            }
        }
        return true;

    }
    public boolean judgeCurLevelHasLeft(LinkedList<TreeNode> myQueue) {
        for (TreeNode node : myQueue) {
            if (order(node)) {
                return true;
            }
        }
        return false;
    }

    public boolean order(TreeNode root) {
        if (root == null) {
            return false;
        }
        order(root.left);
        if (root.left != null) {
            result = root.left.val;
            return true;
        }
        order(root.right);
        return false;
    }
}
