package Tree;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/13 12:08
 * @description 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * 110. 平衡二叉树
 **/
public class isBalanced_ {
    public boolean isBalanced(TreeNode root) {
        /**
         * 递归法:
         * 首先得有一个求节点高度的函数再进行递归:
         * 递归的停止条件是找到空节点;以左右子树的高度差是否为大于一来判断是否是平衡二叉树
         *
         */
        return getHeight(root)!=-1;

    }
    public int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftHeight=getHeight(root.left);
        if(leftHeight==-1){
            return -1;
        }
        int rightHeight=getHeight(root.right);
        if(rightHeight==-1){
            return -1;
        }
        //左右子树高度差大于1,说明不是平衡二叉树:
        if(Math.abs(leftHeight-rightHeight)>1){
            return -1;
        }
        //若为平衡二叉树则正常返回高度
        //正常返回高度
        return Math.max(leftHeight,rightHeight)+1;
    }
    /**
     * 迭代版本若时间复杂度需要降到O(n)还是挺难想得
     */
}
