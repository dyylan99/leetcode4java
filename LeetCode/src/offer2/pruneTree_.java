package offer2;

import Tree.TreeNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/17 17:00
 * @description TODO
 **/
public class pruneTree_ {
    public TreeNode pruneTree(TreeNode root) {
        return dfs(root);
    }
    private TreeNode dfs(TreeNode node){
        if (node==null){
            return null;
        }
        node.left=dfs(node.left);
        node.right=dfs(node.right);

        return node.left==null&&node.right==null&&node.val==0?null:node;
    }
}
