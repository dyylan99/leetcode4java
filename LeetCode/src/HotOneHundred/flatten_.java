package HotOneHundred;

import Tree.TreeNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/6 13:35
 * @description 114. 二叉树展开为链表
 *
 *
 **/
public class flatten_ {
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode left=root.left;
        TreeNode right=root.right;

        root.left=null;
        root.right=left;

        TreeNode p=root;
        while (p.right!=null){
            p=p.right;
        }
        p.right=right;
    }

}
