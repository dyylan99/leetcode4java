package cn.dylan.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/17 14:08
 * @description 二叉树的中序遍历, 非递归版本
 **/
public class inorder_ {

    public List<Integer>inorder(TreeNode root){
        List<Integer>res=new ArrayList<>();
        if (root==null){
            return res;
        }
        Stack<TreeNode>s=new Stack<>();
        TreeNode cur=root;
        while (!s.isEmpty() || cur!=null){
           if (cur!=null){
               s.push(cur);
               cur=cur.left;
           }else{
               cur=s.pop();
               res.add(cur.val);
               cur=cur.right;
           }
        }
        return res;
    }

}
