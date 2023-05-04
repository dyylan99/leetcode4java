package offer2;

import Tree.TreeNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/5/1 14:54
 * @description 剑指 Offer II 054. 所有大于等于节点的值之和
 **/
public class convertBST_ {
    int val=0;
    public TreeNode convertBST(TreeNode root) {
        /**
         * 根节点为: 根节点+右子树的值
         * 左节点: 父节点加上父节点的右子树的值
         * 右节点: 右节点+右子树的值
         */
        //遍历方式为: 右->中->左
        if (root==null){
            return null;
        }
        convertBST(root.right);
        val+=root.val;
        root.val=val;
        convertBST(root.left);
        return root;
    }

}
