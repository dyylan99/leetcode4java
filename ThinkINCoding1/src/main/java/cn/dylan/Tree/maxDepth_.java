package cn.dylan.Tree;

/**
 *@author Dylan
 *@date 2023/9/27 13:59
 *@version 1.0
 *@description 104. 二叉树的最大深度
 **/
public class maxDepth_ {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }
    private int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=1+dfs(root.left);
        int right=1+dfs(root.right);
        return Math.max(left,right);

    }
}
