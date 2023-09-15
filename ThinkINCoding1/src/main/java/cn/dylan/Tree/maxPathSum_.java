package cn.dylan.Tree;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/14 19:00
 * @description 124. 二叉树中的最大路径和
 **/
public class maxPathSum_ {
    int res=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root){
        if (root==null){
            return 0;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);
        res=Math.max(res,root.val+left+right);
        int max=Math.max(root.val+left,root.val+right);

        return max<0 ? 0 : max;
    }
}
