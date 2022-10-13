package Tree;

import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/13 15:40
 * @description 给定二叉树的根节点 root ，返回所有左叶子之和。
 * 404. 左叶子之和
 **/
public class sumOfLeftLeaves_ {
    /**
     * 递归:找到所有的左叶子, 并相加
     * 左叶子:该节点的左孩子不为空, 且左孩子的左右节点都为空
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        return findSum(root);
    }
    public int findSum(TreeNode root){
        //若为空节点则返回0
        if(root==null){
            return 0;
        }
        int sum=0;
        //找到了左孩子
        if(root.left!=null&&root.left.right==null&&root.left.left==null){
            sum=root.left.val;
        }
        return sum+findSum(root.left)+findSum(root.right);
    }

    /**
     * 迭代:
     */
    public int sumOfLeftLeaves1(TreeNode root){
        if(root==null){
            return 0;
        }
        int res=0;
        Stack<TreeNode>stack=new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            TreeNode cur=stack.pop();
            //找到了左叶子
            if(cur.left!=null&&cur.left.right==null&&cur.left.left==null){
                res+=cur.left.val;
            }
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if (cur.left!=null){
                stack.push(cur.left);
            }
        }
        return res;
    }
}
