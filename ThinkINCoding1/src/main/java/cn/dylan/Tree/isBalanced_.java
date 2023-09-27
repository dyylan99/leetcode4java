package cn.dylan.Tree;

/**
 *@author Dylan
 *@date 2023/9/27 14:07
 *@version 1.0
 *@description 110. 平衡二叉树
 **/
public class isBalanced_ {
    boolean res=true;
    public boolean isBalanced(TreeNode root) {
        balance(root);
        return res;
    }
    private  int balance(TreeNode root){
        if (root==null){
            return 0;
        }
        int left=1+balance(root.left);
        int right=1+balance(root.right);
        if(Math.abs(left-right)>1){
            res=false;
        }
        return Math.max(left,right);
    }
}
