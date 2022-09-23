package com.goo.test.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Lenovo
 */
public class BinaryTreeLevelOrderTraversal {

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
        List<List<Integer>> res = levelOrder(A);
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.println(integer);
            }
        }


    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> myQueue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        myQueue.add(root);
        while (!myQueue.isEmpty()) {
            result.add(calcLevelTree(myQueue));
        }
        //反转 力扣 107题
        Collections.reverse(result);
        return result;
    }

    public List<Integer> calcLevelTree(LinkedList<TreeNode> myQueue) {
        List<Integer> result = new ArrayList<>();
        int size = myQueue.size();
        for (int i = 0; i < size; i++) {
            TreeNode node = myQueue.get(0);
            result.add(node.val);
            myQueue.remove(0);
            if (node.left != null) {
                myQueue.add(node.left);
            }
            if (node.right != null) {
                myQueue.add(node.right);
            }
        }
        return result;
    }
}
