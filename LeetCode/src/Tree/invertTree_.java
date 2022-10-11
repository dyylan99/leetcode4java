package Tree;

import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/11 15:24
 * @description 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * 226. 翻转二叉树
 **/
public class invertTree_ {
    /**
     * 思路:
     * 反转每个节点的左右孩子即可达到效果
     */
    //递归法
    public TreeNode invertTree(TreeNode root) {
        //确定终止条件
        if(root==null){
            return root;
        }
        /**
         * 确定逻辑:
         * 先交换当前节点的左右孩子,然后再遍历左子树,右子树
         */
        TreeNode cur=root.left;//
        root.left=root.right;//交换左右节点的步骤是对当前节点操作, 而后操作左节点, 右节点, 所以此步骤为前序遍历
        root.right=cur;//
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    //迭代法
    public TreeNode invertTree1(TreeNode root){
        //能用递归的解法一般都能使用栈来解
        if(root==null){
            return root;
        }
        Stack<TreeNode>stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur=stack.pop();
            if(cur!=null) {
                TreeNode intermediate = cur.left;
                cur.left = cur.right;
                cur.right = intermediate;
                stack.push(cur.right);
                stack.push(cur.left);
            }
        }
        return root;
    }
}
