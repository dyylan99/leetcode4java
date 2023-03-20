package offer;

import Tree.TreeNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/19 13:24
 * @description 剑指 Offer 27. 二叉树的镜像
 **/
public class mirrorTree_ {
    public TreeNode mirrorTree(TreeNode root) {

        exchange(root);
        return root;
    }

    /**
     * 原则:每个节点的左右子树的节点值都要交换,直到左右子树都为空为止
     */
    private void exchange(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            return;
        }
        TreeNode node=root.left;
        root.left=root.right;
        root.right=node;
        exchange(root.left);
        exchange(root.right);
    }

}
