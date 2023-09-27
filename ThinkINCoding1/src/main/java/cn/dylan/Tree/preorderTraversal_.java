package cn.dylan.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/27 13:44
 * @description TODO
 **/
public class preorderTraversal_ {
    List<Integer>list=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        //迭代
        List<Integer>res=new ArrayList<>();
        Stack<TreeNode>s=new Stack<>();
        while (root!=null || !s.isEmpty()){
            while (root!=null){
                res.add(root.val);
                s.push(root);
                root=root.left;
            }
            root=s.pop().right;
        }
        return res;
    }
    //递归
    private void preTraverse(TreeNode root){
        if(root==null){
            return;
        }
        list.add(root.val);
        preTraverse(root.left);
        preTraverse(root.right);
    }
}
