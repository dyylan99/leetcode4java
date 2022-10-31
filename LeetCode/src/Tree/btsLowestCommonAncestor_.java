package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/24 16:10
 * @description 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
 *235. 二叉搜索树的最近公共祖先
 **/
public class btsLowestCommonAncestor_ {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 由于二叉搜索树是有序的, 二个节点的最近公共祖先一定是从上到下遍历的第一个位于[p,q]区间内的节点
         */
        //采用层序遍历:
        Queue<TreeNode> q1=new ArrayDeque<>();
        q1.add(root);
        int max=Math.max(p.val,q.val);
        int min=Math.min(p.val,q.val);
        while (!q1.isEmpty()){
            int len=q1.size();
            for (int i = 0; i < len; i++) {
                TreeNode node=q1.poll();
                if(node.val>=min&&node.val<=max){
                    return node;
                }
                if(node.left!=null){
                    q1.add(node.left);
                }
                if(node.right!=null){
                    q1.add(node.right);
                }
            }
        }
        return null;
    }
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q){
        //迭代版本二
        while (true) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            }else if(root.val<q.val&&root.val<p.val){
                root=root.right;
            }else{
                return root;
            }
        }
    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
        //递归
        if (root.val > p.val && root.val > q.val){
            return lowestCommonAncestor2(root.left,p,q);
        }
        if(root.val<q.val&&root.val<p.val){
            return lowestCommonAncestor2(root.right,p,q);
        }
        return root;
    }

}
