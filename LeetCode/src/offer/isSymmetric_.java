package offer;

import Tree.TreeNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/19 13:46
 * @description 剑指 Offer 28. 对称的二叉树
 **/
public class isSymmetric_ {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSame(root.left,root.right);
    }
    /**
     * 原则: 比较两颗树的左节点和右节点是否相同
     */
    private boolean isSame(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }else if((left!=null&&right==null)||(left==null&&right!=null)){
            return false;
        }else{
            //都不为空: 比较左左-右右&&左右-右左
            if(left.val==right.val){
                return isSame(left.left,right.right)&&isSame(left.right,right.left);
            }else{
                return false;
            }
        }
    }

}
