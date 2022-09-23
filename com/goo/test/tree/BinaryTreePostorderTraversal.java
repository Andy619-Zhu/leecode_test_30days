package com.goo.test.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {

    @Test
    public void test() {
        TreeNode A = new TreeNode(5);
        TreeNode B = new TreeNode(1);
        TreeNode C = new TreeNode(4);
        TreeNode D = new TreeNode(3);
        TreeNode E = new TreeNode(6);
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

        A.left = B;
        A.right = C;
//        B.left = D;
//        B.right = E;
        C.left = D;
        C.right = E;
//        D.left = H;
//        D.right = I;
//        E.left = J;
//        E.right = K;
//        F.left = L;
//        F.right = M;
//        H.left = N;
//        H.right = O;
        List<Integer> res = postorderTraversal(A);

        System.out.println(res);

    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> RES = new ArrayList<>();
//        postOrder(root,RES);
        isBST(root,RES);
        return RES;
    }
    public void postOrder(TreeNode root, List<Integer> RES){
        if(root==null){
            return;
        }

        postOrder(root.left,RES);
        postOrder(root.right,RES);
        RES.add(root.val);
    }

    private void isBST(TreeNode root,List<Integer> list) {
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        if (root.left != null) {
            if (root.left.val < root.val){
                list.add(root.val);
                isBST(root.left,list);
            }else {
                list.add(Integer.MAX_VALUE);
                return;
            }
        }
        if (root.right!= null) {
            if (root.right.val > root.val){
                list.add(root.val);
                isBST(root.right,list);
            }else {
                list.add(Integer.MIN_VALUE);
                return;
            }
        }
    }
}
