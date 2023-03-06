package HotOneHundred;

import Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/3 11:23
 * @description TODO
 **/
public class isSymmetric_ {
    public boolean isSymmetric(TreeNode root) {

        return isValEquals(root.left,root.right);
    }
    //递归
    public boolean isValEquals(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null){
            return false;
        }
        if(right==null){
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        boolean res1 = isValEquals(left.left, right.right);
        boolean res2=isValEquals(left.right,right.left);
        return res1&&res2;
    }

}
