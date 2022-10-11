package TreeTrain;

import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/6/18 12:15
 * @description 操作给定的二叉树，将其变换为源二叉树的镜像。
 * ---->求镜像的核心要义就是:交换所有节点的所有左右子树
 **/
public class MirrorTree {


    public TreeNode Mirror (TreeNode pRoot) {
        /**
         * 由于本题有空间复杂度为O(1)的解法,所以想到使用指针两边同时遍历,遍历的同时换值
         * 1.判断根节点是否为空指针
         * 2.根节点的左子树采用从左往右的遍历方式,右子树采用从右往左的遍历方式
         *
         */
        if(pRoot==null){
            return pRoot;
        }
        /**
         * 找到当前根节点的最左边的节点
         */
        TreeNode l=Mirror(pRoot.left);
        /**
         * 找到当前根节点的最右边的节点
         */
        TreeNode r=Mirror(pRoot.right);

        pRoot.left=r;
        pRoot.right=l;

        return pRoot;

    }
    /**
     * 借助栈的处理方式
     */
    public TreeNode Mirror1 (TreeNode pRoot){
        if(pRoot==null){
            return null;
        }
        Stack<TreeNode>s=new Stack<>();
        s.push(pRoot);
        while(!s.empty()){
            TreeNode node=s.pop();
            if(node.left!=null){
                s.push(node.left);
            }
            if(node.right!=null){
                s.push(node.right);
            }
            TreeNode t=node.left;
            node.left=node.right;
            node.right=t;
        }
        return pRoot;
    }


}
