package learn_base;

import org.junit.Test;

import java.util.Stack;

/**
 * @author Lenovo
 */
public class LearnTree {

    public TreeNode createTree(){
        TreeNode A = new TreeNode('a');
        TreeNode B = new TreeNode('b');
        TreeNode C = new TreeNode('c');
        TreeNode D = new TreeNode('d');
        TreeNode E = new TreeNode('e');
        TreeNode F = new TreeNode('f');
        TreeNode G = new TreeNode('g');
        TreeNode H = new TreeNode('h');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }

    void preOrderTraversal(TreeNode root){
        if (root == null){
            return;
        }
        System.out.println(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    /**
     * 前序遍历顺序：中-左-右，入栈顺序：中-右-左
     * @param root
     */
    void preOrderTraversal2(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right!=null){
                stack.push(node.right);
            }
            if (node.left!=null){
                stack.push(node.left);
            }
        }
    }


    void inOrderTraversal(TreeNode root){
        if (root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.val + " ");
        inOrderTraversal(root.right);
    }

    /**
     * 中序遍历顺序: 左-中-右 入栈顺序： 左-右
     * @param root
     */
    void inOrderTraversal2(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!= null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                System.out.println(cur.val);
                cur = cur.right;
            }
        }
    }

    void postOrderTraversal(TreeNode root){
        if (root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.val + " ");
    }

    /**
     * 后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
     */
    void postOrderTraversal2(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right!=null){
                stack.push(node.right);
            }
            if (node.left!=null){
                stack.push(node.left);
            }
        }
    }



    @Test
    public void test(){
        TreeNode A = createTree();
        System.out.println("前序遍历1");
        preOrderTraversal(A);
        System.out.println("前序遍历2");
        preOrderTraversal2(A);
        System.out.println("中序遍历");
        inOrderTraversal(A);
        System.out.println("后序遍历");
        postOrderTraversal(A);
    }



}

class TreeNode {
    public char val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }
}