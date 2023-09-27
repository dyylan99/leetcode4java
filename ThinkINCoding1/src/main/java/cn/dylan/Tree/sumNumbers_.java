package cn.dylan.Tree;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/20 16:19
 * @description 129. 求根节点到叶节点数字之和
 **/
public class sumNumbers_ {
    public int sumNumbers(TreeNode root) {
        return traverse(root,0);
    }

    private int traverse(TreeNode root, int cur){
        if (root==null){
            return 0;
        }
        cur=cur*10+root.val;
        if (root.left==null && root.right==null)return cur;
        return traverse(root.left,cur)+traverse(root.right,cur);
    }
}
