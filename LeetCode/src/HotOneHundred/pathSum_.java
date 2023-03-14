package HotOneHundred;

import Tree.TreeNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/13 13:19
 * @description TODO
 **/
public class pathSum_ {
    private int res;

    public int pathSum(TreeNode root, int targetSum) {
        //遍历整棵树,每棵树都调用一次isEquals函数
        tars(root,targetSum);
        return res;
    }

    public void tars(TreeNode root,long target){
        if(root==null){
            return;
        }
        isEquals(root,target);
        tars(root.left,target);
        tars(root.right,target);
    }

    //遍历以root节点为起始节点的路径,判断是否路径和等于target
    public void isEquals(TreeNode root,long cur){
        if(root==null){
            return;
        }
        if(cur==root.val){
            res++;
        }
        cur-=root.val;
        long left=cur;
        long right=cur;
        //遍历左子树
        isEquals(root.left,left);
        //右子树
        isEquals(root.right,right);
    }
}
