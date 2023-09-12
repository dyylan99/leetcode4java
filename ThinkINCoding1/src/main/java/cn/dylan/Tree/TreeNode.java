package cn.dylan.Tree;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/11 14:23
 * @description TODO
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val=val;
    }
    public TreeNode(int val,TreeNode left,TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
