package com.goo.test.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lenovo
 */
public class BinaryTreePreorderTraversal {

    @Test
    public void test(){
        TreeNode A = new TreeNode(3);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(1);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);
        TreeNode G = new TreeNode(7);
        TreeNode H = new TreeNode(8);
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        List<Integer> res = preorderTraversal(A);
        preOrder(A,new ArrayList<>());
        for (Integer re : res) {
            System.out.println(re);
        }

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> RES = new ArrayList<>();
        preOrder2(root,5);
        return RES;
    }
    public void preOrder(TreeNode root, List<Integer> RES){
        if(root==null){
            return;
        }
        RES.add(root.val);
        preOrder(root.left,RES);
        preOrder(root.right,RES);
    }
    public void preOrder2(TreeNode root, int rES){
        if(root==null){
            return;
        }
        rES = rES - 1;
        System.out.println(rES);
        preOrder2(root.left,rES);
        preOrder2(root.right,rES);
    }
}
