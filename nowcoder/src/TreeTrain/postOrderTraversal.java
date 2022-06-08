package TreeTrain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/6/8 11:36
 * @description 给定一个二叉树，返回他的后序遍历的序列。
 *
 * 后序遍历是值按照 左节点->右节点->根节点 的顺序的遍历。
 **/
public class postOrderTraversal {
    /**
     * 递归版本
     */
    public int[] postorderTraversal (TreeNode root) {
        List<Integer>list=new ArrayList<>();
        /**
         * 前序遍历:
         */
        postorder(list,root);
        /**
         * 将输出的值存放在int[]数组中
         */
        int[]res=new int[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            res[i]=list.get(i);
        }
        return res;
    }
    public void postorder(List<Integer>list,TreeNode root){
        if(root==null){
            return;
        }
        postorder(list,root.left);
        postorder(list,root.right);
        list.add(root.val);
    }

    /**
     * 非递归版本
     */
    public int[] postorderTraversal1 (TreeNode root){
        if(root==null){
            return new int[0];
        }
        List<Integer>list=new ArrayList<>();
        Stack<TreeNode>stack=new Stack<>();
        TreeNode node=root;
        /**
         * pre用做标记,标记节点的右节点是否被遍历过,若遍历过则取节点值,未遍历且不为空的情况下就去找右子树.
         * 当然左子树在此前已近遍历
         */
        TreeNode pre=null;
        while(node!=null||!stack.empty()){
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
            node=stack.peek();
            if(node.right!=null&&pre!=node.right){
               node=node.right;
            }else{
                list.add(node.val);
                stack.pop();
                pre=node;
                node=null;
            }
        }

        int[]res=new int[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            res[i]=list.get(i);
        }
        return res;
    }

}
