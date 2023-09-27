package cn.dylan.Tree;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/27 13:37
 * @description 543. 二叉树的直径
 **/
public class diameterOfBinaryTree_ {
    int res=0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }
    private int dfs(TreeNode root){
        if(root==null){
            return -1;
        }
        int rLength=1+dfs(root.right);
        int lLength=1+dfs(root.left);
        res=Math.max((rLength+lLength),res);
        return Math.max(rLength,lLength);
    }
}
