package Tree;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/31 14:43
 * @description 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。
 * 通过修剪二叉搜索树，使得所有节点的值在[low, high]中。
 * 修剪树 不应该改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在唯一的答案。
 *
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 *669. 修剪二叉搜索树
 **/
public class trimBST_ {
    //方法一:递归
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null){
            return null;
        }
        if(root.val<low){
            return trimBST(root.right,low,high);
        }
        if(root.val>high){
            return trimBST(root.left,low,high);
        }
        root.right=trimBST(root.right,low,high);
        root.left=trimBST(root.left,low,high);
        return root;
    }

    //方法二:迭代
    /**
     * 迭代法
     * 因为二叉搜索树的有序性，不需要使用栈模拟递归的过程。
     * 在剪枝的时候，可以分为三步：
     *
     * 将root移动到[L, R] 范围内，注意是左闭右闭区间
     * 剪枝左子树
     * 剪枝右子树
     */
    public TreeNode trimBST1(TreeNode root, int low, int high){
        if(root==null){
            return null;
        }
        while (root!=null&&(root.val<low||root.val>high)){
            if(root.val<low){//小于最小值往右走
                root=root.right;
            }else{//大于最大值往左走
                root=root.left;
            }
        }
        TreeNode cur=root;
        while (cur!=null){//处理左子树小于最小值的情况
            while (cur.left!=null&&cur.left.val<low){
                cur.left=cur.left.right;
            }
            cur=cur.left;
        }
        cur=root;
        while (cur!=null){//处理右子树大于最大值的情况
            while (cur.right!=null&&cur.right.val>high){
                cur.right=cur.right.left;
            }
            cur=cur.right;
        }
        return root;
    }
}

