package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/18 15:01
 * @description 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 98. 验证二叉搜索树
 **/
public class isValidBST_ {
    TreeNode max;
    public boolean isValidBST(TreeNode root) {
        //List<Integer>list=new ArrayList<>();
        //inorderTra(root,list);
        //for (int i = 0; i < list.size()-1; i++) {
        //    if(list.get(i)>=list.get(i+1)){
        //        return false;
        //    }
        //}
        //return true;
        if(root==null){
            return true;
        }
        Stack<TreeNode>s=new Stack<>();
        TreeNode pre=null;
        while (root!=null||!s.empty()){
            while (root!=null){
                s.push(root);
                root=root.left;//左
            }
            //中.=,处理
            TreeNode pop=s.pop();
            if(pre!=null&&pop.val<=pre.val){
                return false;
            }
            pre=pop;
            root=pop.right;//右
        }
        return true;
    }
    public boolean isValidBST1(TreeNode root) {
        /**
         * 递归:
         *  核心要义是二叉搜索树的中序遍历得到的数组为由小到大的有序数组
         */
        if(root==null){
            return true;
        }
        boolean left=isValidBST1(root.left);//左
        if(!left){
            return false;
        }

        if(max!=null&&root.val<=max.val){//中
            return false;
        }
        max=root;
        boolean right=isValidBST1(root.right);//右
        return right;
    }

    /**
     * 该版本是对上方递归版本的解释
     * @param root
     * @param list
     */
    public void inorderTra(TreeNode root, List<Integer>list){
        if(root==null){
            return;
        }
        inorderTra(root.left,list);
        list.add(root.val);
        inorderTra(root.right,list);
    }

}
