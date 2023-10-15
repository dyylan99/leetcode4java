package cn.dylan.Tree;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/28 16:02
 * @description 98. 验证二叉搜索树
 **/
public class isValidBST_ {
    //二叉搜索树在中序遍历的情况下有序
    TreeNode pre;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }

}
