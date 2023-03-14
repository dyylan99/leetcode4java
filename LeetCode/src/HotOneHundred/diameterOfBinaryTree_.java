package HotOneHundred;

import Tree.TreeNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/13 14:23
 * @description 543. 二叉树的直径
 **/
public class diameterOfBinaryTree_ {
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        //最长路径: 一定是某个节点的左子树最长路径+右子树最长路径-->一定会经过某个节点
        /**
         * 因此我们写出经过节点的最长路径再把二叉树遍历一遍就可以
         */
        if (root==null){
            return 0;
        }
        longestLen(root);
        return max;
    }

    public int longestLen(TreeNode root){
        if(root.left==null&&root.right==null){
            return 0;
        }
        int leftLen=root.left==null?0:longestLen(root.left)+1;
        int rightLen=root.right==null?0:longestLen(root.right)+1;
        max=Math.max(max,leftLen+rightLen);
        return Math.max(leftLen,rightLen);
    }
}
