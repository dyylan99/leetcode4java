package cn.dylan.Tree;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/14 18:37
 * @description 236. 二叉树的最近公共祖先
 **/
public class lowestCommonAncestor_ {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 首先我们确认一点：我们的p、q都是存在于root中的，因此对于一颗树，当root为p或q时，直接返回root即可。
         * 对于root不为p或q的树，就从它的左子树和右子树分别查找结果，当l和r皆非空时，说明pq分布于root的两侧（因为递归访问到pq时直接返回了），
         * 因此返回root，否则返回非空的那个
         */
        if(root==null || root==p || root==q){
            return root;
        }
        TreeNode first = lowestCommonAncestor(root.left, p, q);
        TreeNode second = lowestCommonAncestor(root.right, p, q);
        if (first!=null && second!=null){
            return root;
        }
        if (first!=null){
            return first;
        }
        if (second!=null){
            return second;
        }
        return null;
    }
}
