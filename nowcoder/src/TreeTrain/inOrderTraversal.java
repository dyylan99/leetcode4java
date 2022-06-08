package TreeTrain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/6/8 11:15
 * @description 给定一个二叉树的根节点root，返回它的中序遍历结果。
 *
 * 数据范围：树上节点数满足 0≤n≤1000，树上每个节点的值满足 0≤val≤1000
 * 进阶：空间复杂度 O(n)，时间复杂度 O(n)
 * 中序遍历:先访问左子树,再访问根节点,再访问右子树
 **/
public class inOrderTraversal {
    public int[] inorderTraversal (TreeNode root) {
        /**
         * 非递归写法:
         * 借助栈与数组
         */
        if(root==null){
            return new int[0];
        }
        List<Integer>list=new ArrayList<>();
        Stack<TreeNode>stack=new Stack<>();
        TreeNode node=root;
        while(node!=null||!stack.empty()){
             while(node!=null){
                 stack.push(node);
                 node=node.left;
             }
             if(!stack.empty()){
                 node=stack.pop();
                 list.add(node.val);
                 node=node.right;
             }
        }
        int[]res=new int[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            res[i]=list.get(i);
        }
        return res;
    }
    /**
     * 使用递归:
     */
    public int[] inorderTraversal1 (TreeNode root){
        List<Integer>list=new ArrayList<>();
        /**
         * 前序遍历:
         */
        inorder(list,root);
        /**
         * 将输出的值存放在int[]数组中
         */
        int[]res=new int[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            res[i]=list.get(i);
        }
        return res;
    }
    public void inorder(List<Integer>list,TreeNode root){
        /**
         * 找到叶子结点时停止继续往下找
         */
        if(root==null){
            return;
        }
        /**
         * 先遍历左子树
         */
        inorder(list,root.left);
        /**
         * 再遍历根节点
         */
        inorder(list,root);
        /**
         * 最后遍历右子树
         */
        inorder(list,root.right);

    }

}
