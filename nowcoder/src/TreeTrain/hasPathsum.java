package TreeTrain;

import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/6/10 9:18
 * @description 给定一个二叉树root和一个值 sum ，判断是否有从根节点到叶子节点的节点值之和等于 sum 的路径。
 * 1.该题路径定义为从树的根结点开始往下一直到叶子结点所经过的结点
 * 2.叶子节点是指没有子节点的节点
 * 3.路径只能从父节点到子节点，不能从子节点到父节点
 * 4.总节点数目为n
 **/
public class hasPathsum {
    public boolean hasPathSum (TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null&&sum-root.val==0){
            return true;
        }
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum- root.val);
    }


    /**
     * 非递归版本:
     * 使用栈加上深度优先搜索
     * 深度优先搜索一般用于树或者图的遍历，
     * 其他有分支的（如二维矩阵）也适用。
     * 它的原理是从初始点开始，一直沿着同一个分支遍历，直到该分支结束，然后回溯到上一级继续沿着一个分支走到底，
     * 如此往复，直到所有的节点都有被访问到。
     */
    public boolean hasPathSum1(TreeNode root,int sum){
        if(root==null){
            return false;
        }
        Stack<TreeNode>stack1=new Stack<>();
        Stack<Integer>stack2=new Stack<>();
        stack1.push(root);
        stack2.push(root.val);
        while(!stack1.empty()){
            TreeNode cur = stack1.pop();
            int cur_sum=stack2.pop();
            if(cur.left==null&&cur.right==null&&cur_sum==sum){
            return true;
            }
            if(cur.left!=null){
                stack1.push(cur.left);
                stack2.push(cur_sum+cur.left.val);
            }
            if(cur.right!=null){
                stack1.push(cur.right);
                stack2.push(cur.right.val+cur_sum);
            }
        }
        return false;

    }
}
