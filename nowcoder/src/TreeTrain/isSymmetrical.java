package TreeTrain;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/6/13 15:39
 * @description 给定一棵二叉树，判断其是否是自身的镜像（即：是否对称）
 **/
public class isSymmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        /**
         * 思路一:层序遍历
         * 但是是从第二层开始,左边从左往右,右边从右往左
         */
        if(pRoot==null){
            return true;
        }
        Queue<TreeNode>q1=new LinkedList<>();
        Queue<TreeNode>q2=new LinkedList<>( );
        q1.offer(pRoot.left);
        q2.offer(pRoot.right);
        while(!q1.isEmpty()&&!q2.isEmpty()){
            TreeNode left = q1.remove();
            TreeNode right = q2.remove();
            if(left==null&&right==null){
               continue;
            }
            if(left==null||right==null||left.val!=right.val){
                return false;
            }
            q1.offer(left.left);
            q1.offer(left.right);
            q2.offer(right.right);
            q2.offer(right.left);
        }
        return true;
    }
    /**
     * 方法二:采用递归的方式
     */
    public boolean recursion(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null||left.val!=right.val){
            return false;
        }
        return recursion(left.left,right.right)&&recursion(left.right,right.left);
    }
}
