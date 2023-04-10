package offer2;

import Tree.TreeNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/10 14:23
 * @description TODO
 **/
public class maxPathSum_ {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        /**
         * 可以简化为两种情况
         * 1:其左右子树所构成的路径值较大的那个加上该节点的值
         * 2:左右子树都在最大路径中,再加上该节点的值
         */
        getMax(root);
        return max;
    }

    private int getMax(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=Math.max(0,getMax(root.left));
        int right=Math.max(0,getMax(root.right));
        max=Math.max(max,root.val+left+right);
        return Math.max(left,right)+root.val;
    }
}
