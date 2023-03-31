package offer;

import Tree.TreeNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/31 15:18
 * @description TODO
 **/
public class lowestCommonAncestor_ {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if(root.val>p.val&&root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(root.val<p.val&&root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
}
