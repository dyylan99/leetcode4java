package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/11 15:22
 * @description 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * 145. 二叉树的后序遍历
 **/
public class postorderTraversal_ {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        postorder(root,list);
        return list;
    }
    //迭代版本:
    public void postorder(TreeNode cur, List<Integer> list){
        //退出条件:
        if(cur==null){
            return;
        }
        //遍历左子树
        postorder(cur.left,list);
        //遍历右子树
        postorder(cur.right,list);
        list.add(cur.val);
    }
    //采用空节点作为标记,空节点--统一迭代法
    public void postorder1(TreeNode cur,List<Integer>list){
        Stack<TreeNode> st=new Stack<>();
        if(cur!=null)st.push(cur);
        while(!st.empty()){
            TreeNode node=st.peek();
            if(node!=null){
                st.pop();
                st.push(node);
                st.push(null);
                if(node.right!=null){
                    st.push(node.right);
                }
                if(node.left!=null){
                    st.push(node.left);
                }

            }else{
                st.pop();
                node=st.pop();
                list.add(node.val);
            }
        }

    }
}
