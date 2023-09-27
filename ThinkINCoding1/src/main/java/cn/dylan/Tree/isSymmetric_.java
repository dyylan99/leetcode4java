package cn.dylan.Tree;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/20 16:30
 * @description 101. 对称二叉树
 **/
public class isSymmetric_ {
    public boolean isSymmetric(TreeNode root) {
        if (root.left==null || root.right==null){
            return false;
        }
        return traverse(root.left,root.right);
    }

    public boolean traverse(TreeNode left, TreeNode right){
        if (left==null && right==null){
            return true;
        }else if (left==null || right==null){
            return false;
        }else{
            if (left.val==right.val){
                return traverse(left.right,right.left)&&traverse(left.left,right.right);
            }else{
                return false;
            }
        }

    }
    @Test
    public void test(){
        TreeNode root=new TreeNode(0);
        root.left=new TreeNode(1);
        root.right=new TreeNode(2);
        System.out.println(isSymmetric(root));
    }
}
