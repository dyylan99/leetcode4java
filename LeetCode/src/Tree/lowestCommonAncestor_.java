package Tree;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/24 15:34
 * @description 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *236. 二叉树的最近公共祖先
 **/
public class lowestCommonAncestor_ {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 后序遍历回溯解决:
         */
        if(root==null||root==p||root==q){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left==null&&right==null){//未找到节点
            return null;
        }else if(left!=null&&right==null){//只找到一个节点
            return left;
        }else if(left == null){//只找到一个节点
            return right;
        }else{//找到两个节点
            return root;
        }
    }

}
