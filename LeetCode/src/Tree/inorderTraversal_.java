package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/11 15:21
 * @description 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * 94. 二叉树的中序遍历
 **/
public class inorderTraversal_ {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>list=new LinkedList<>();
        //inorder(root,list);
        return inorder2(root,list);
    }
    //递归版本
    public void inorder(TreeNode cur,List<Integer>list){
        if(cur==null){
            return;
        }
        inorder(cur.left,list);
        list.add(cur.val);
        inorder(cur.right,list);
    }
    //非递归版本1
    public List<Integer> inorder1(TreeNode root, List<Integer>list){
        Stack<TreeNode>stack=new Stack<>();
        if(root==null){
            return list;
        }
        TreeNode cur=root;
        while(!stack.empty()||cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                cur=stack.pop();
                list.add(cur.val);
                cur=cur.right;
            }
        }
        return list;
    }
    //非递归版本二, 对即将要处理的节点使用null标记, 使得三种递归方式采用一种思路:--统一迭代法
    public List<Integer> inorder2(TreeNode root, List<Integer>list){
        Stack<TreeNode> stack=new Stack<>();
        if(root!=null)stack.push(root);
        while(!stack.empty()){
            TreeNode cur=stack.peek();
            if(cur!=null){
                stack.pop();
                if(cur.right!=null)stack.push(cur.right);

                stack.push(cur);
                stack.push(null);
                if(cur.left!=null)stack.push(cur.left);


            }else{
                stack.pop();
                cur=stack.peek();
                stack.pop();
                list.add(cur.val);
            }
        }
        return list;
    }

}
