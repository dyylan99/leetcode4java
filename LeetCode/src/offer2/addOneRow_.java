package offer2;

import Tree.TreeNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/20 16:05
 * @description TODO
 **/
public class addOneRow_ {
    int level;
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth==1){
            return new TreeNode(val,root,null);
        }
        level=depth;
        dfs(root,val,1);
        return root;
    }
    void dfs(TreeNode root,int val,int deep){
        if (root==null){
            return;
        }
        if (deep==level-1){
            TreeNode l=root.left;
            TreeNode r=root.right;
            root.left=new TreeNode(val,l,null);
            root.right=new TreeNode(val,null,r);
        }
        dfs(root.left,val,deep+1);
        dfs(root.right,val,deep+1);
    }
}
