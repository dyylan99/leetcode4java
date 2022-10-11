package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/11 15:22
 * @description 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 144. 二叉树的前序遍历
 **/
public class preorderTraversal_ {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        //preorder(root,list);
        return preorder2(root,list);
    }
    //递归版本
    public void preorder(TreeNode cur,List<Integer>list){
        //确定返回条件
        if(cur==null)
            return;
        //将当前遍历的节点值添加到list中
        list.add(cur.val);
        //遍历左节点
        preorder(cur.left,list);
        //遍历右节点
        preorder(cur.right,list);
    }
    //非递归版本
    public List<Integer>preorder1(TreeNode root,List<Integer>list){
        if(root==null){
            return list;
        }
        Stack<TreeNode> st=new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode cur=st.pop();
            if(cur.right!=null){
                st.push(cur.right);
            }
            if(cur.left!=null){
                st.push(cur.left);
            }
            list.add(cur.val);
        }
        return list;
    }
    //采用null标记处理元素--统一迭代法
    public List<Integer> preorder2(TreeNode root, List<Integer>list){
        Stack<TreeNode>st=new Stack<>();
        if(root!=null){
            st.push(root);
        }
        while(!st.empty()){
            TreeNode cur=st.peek();
            if(cur!=null){
                st.pop();
                if(cur.right!=null)st.push(cur.right);
                if(cur.left!=null)st.push(cur.left);
                st.push(cur);
                st.push(null);
            }else{
                st.pop();
                cur=st.pop();
                list.add(cur.val);
            }
        }
        return list;
    }
}
