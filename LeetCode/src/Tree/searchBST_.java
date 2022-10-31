package Tree;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/18 14:50
 * @description 给定二叉搜索树（BST）的根节点root和一个整数值val。
 *
 * 你需要在 BST 中找到节点值等于val的节点。 返回以该节点为根的子树。 如果节点不存在，则返回null
 *700. 二叉搜索树中的搜索
 **/
public class searchBST_ {
    public TreeNode searchBST(TreeNode root, int val) {
        /**
         *迭代法
         */
        while (root!=null){
            if(val>root.val){
                root=root.right;
            }
            else if(val<root.val){
                root=root.left;
            }else{
                return root;
            }
        }
        return null;
    }
    public TreeNode searchBST1(TreeNode root, int val) {
        /**
         *递归:
         *  若搜索的值小于root,则继续搜索其左子树
         *  若搜索的值大于root,则搜索其右子树
         */
        if(root.val==val){
            return root;
        }
        if(root.val<val){
            return searchBST1(root.right,val);
        }
        if(root.val>val){
            return searchBST1(root.left,val);
        }
        //未找到符合的子树
        return null;
    }
}
