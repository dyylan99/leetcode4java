package cn.dylan.Tree;

/**
 *@author Dylan
 *@date 2023/9/27 14:02
 *@version 1.0
 *@description 226. 翻转二叉树
 **/
public class invertTree_ {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
    private void invert(TreeNode root){
        if(root==null || (root.left==null && root.right==null)){
            return;
        }
        if(root.left!=null && root.right!=null){
            TreeNode tem=root.left;
            root.left=root.right;
            root.right=tem;
        }else if(root.left==null){
            root.left=root.right;
            root.right=null;
        }else{
            root.right=root.left;
            root.left=null;
        }
        invert(root.left);
        invert(root.right);
    }
}
