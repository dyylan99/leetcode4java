package offer;

import Tree.TreeNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/27 16:59
 * @description 剑指 Offer 55 - I. 二叉树的深度
 **/
public class maxDepth_ {
    int res=0;
    public int maxDepth(TreeNode root) {
        traverse(root,1);
        return res;
    }

    private void traverse(TreeNode cur,int height){
        if(cur==null){
            return;
        }
        if(height>res){
            res=height;
        }
        traverse(cur.left,height+1);
        traverse(cur.right,height+1);
    }
}
