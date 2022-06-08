package TreeTrain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/6/8 10:47
 * @description 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 **/
public class preOrderTraversal {
/**
 * 二叉树的前序遍历:先遍历根节点,再遍历左子树,最后遍历右子树 ,空节点输出
 */

    public int[] preorderTraversal (TreeNode root) {
        /**
         * 输出的结果放在数组里
         */
        List<Integer>list=new ArrayList<>();
        /**
         * 前序遍历:
         */
        preorder(root,list);
        /**
         * 将输出的值存放在int[]数组中
         */
        int[]res=new int[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            res[i]=list.get(i);
        }
        return res;

    }
    public void preorder(TreeNode root,List<Integer>list){
        /**
         * 遇到叶子结点就返回
         */

      if(root==null){
          return;
      }
        /**
         * 若其值不为空,则将值放在List中
         */
        list.add(root.val);
        /**
         * 再去左子树
         */
        preorder(root.left,list);
        /**
         * 最后去右子树
         */
        preorder(root.right,list);
    }
    /**
     * 非递归版本
     */
    public int[] preorderTraversal1 (TreeNode root){
        if(root==null){
            return new int[0];
        }
        /**
         * 借助数组与栈实现前序遍历
         */
        List<Integer>list=new ArrayList<>();
        Stack<TreeNode>stack=new Stack<>();
        TreeNode node=root;
        while(node!=null||!stack.empty()){
            while(node!=null){
                list.add(node.val);
                stack.push(node);
                node=node.left;
            }
            if(!stack.empty()){
                node=stack.pop();
                node=node.right;
            }
        }
        int[]res=new int[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            res[i]=list.get(i);
        }
        return res;

    }
}
