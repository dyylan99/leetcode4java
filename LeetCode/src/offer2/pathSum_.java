package offer2;

import Tree.TreeNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/15 22:23
 * @description TODO
 **/
public class pathSum_ {
    int res=0;

    public int pathSum(TreeNode root, int targetSum) {
        traverse(root,targetSum);
        return res;
    }

    public void traverse(TreeNode root,int targetSum){
        if (root==null)return;
        nodeSum(root,targetSum,0);
       traverse(root.left,targetSum);
       traverse(root.right,targetSum);
    }

    public void nodeSum(TreeNode cur,int targetSum,long curSum){
        if (cur==null){
            return;
        }
        curSum+=cur.val;
        if (curSum==targetSum){
            res++;
        }

        nodeSum(cur.left,targetSum,curSum);
        nodeSum(cur.right,targetSum,curSum);
    }
}
