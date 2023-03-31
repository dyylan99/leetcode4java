package offer;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/31 15:32
 * @description 剑指 Offer 68 - II. 二叉树的最近公共祖先
 **/
public class lowestCommonAncestor2_ {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 前序遍历根节点到p,q两个节点上的路径,最后一个相同的节点就为最近公共节点
         */

        List<TreeNode>listP=new ArrayList<>();
        List<TreeNode>listQ=new ArrayList<>();
        getPath(root,p,listP);
        getPath(root,q,listQ);
        TreeNode res=null;
        int n=Math.min(listP.size(),listQ.size());
        for (int i = 0; i < n; i++) {
            if(listP.get(i)==listQ.get(i)){
                res=listP.get(i);
            }
        }
        return res;
    }

    //前序遍历搜索p或者q,回溯实现
    void getPath(TreeNode root,TreeNode node,List<TreeNode>list){
        if(root==null){
            return;
        }
        list.add(root);
        if(root==node){
            return;
        }
        if(list.get(list.size()-1)!=node){
            getPath(root.left,node,list);
        }
        if(list.get(list.size()-1)!=node){
            getPath(root.right,node,list);
        }
        if(list.get(list.size()-1)!=node){
            list.remove(list.size()-1);
        }

    }
    //递归
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        if (left != null && right != null) {
            // p q 一个在左，一个在右
            return root;
        }
        if (left != null) {
            // p q 都在左子树
            return left;
        }
        if (right != null) {
            // p q 都在右子树
            return right;
        }
        return null;
    }


}
