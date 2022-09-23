package com.goo.test.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 112题
 * @author Lenovo
 */
public class PathSum {

    @Test
    public void test() {
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
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

        A.left = B;
        A.right = C;
//        B.left = D;
//        B.right = E;
//        C.left = F;
//        C.right = G;
//        D.left = H;
//        D.right = I;
//        E.left = J;
//        E.right = K;
//        F.left = L;
//        F.right = M;
//        H.left = N;
//        H.right = O;
        boolean res = hasPathSum(A, 3);

        System.out.println(res);

    }

    List<Integer> result = new ArrayList<>();

    public boolean hasPathSum(TreeNode root, int targetSum) {
        preOrder(root, new ArrayList<>());

        for (Integer integer : result) {
            if (targetSum == integer) {
                return true;
            }
        }
        return false;
    }


    public void preOrder(TreeNode root, List<Integer> list) {
        List<Integer> listTemp = new ArrayList<>(list);
        if (root == null) {
            return;
        }
        listTemp.add(root.val);
        if (root.left == null && root.right == null) {
            result.add(sum(listTemp));
        } else {

            preOrder(root.left, listTemp);
            preOrder(root.right, listTemp);
        }
    }

    private int sum(List<Integer> listTemp) {
        int res = 0;
        for (Integer resTemp : listTemp) {
            res = res + resTemp;
        }
        return res;
    }
}
