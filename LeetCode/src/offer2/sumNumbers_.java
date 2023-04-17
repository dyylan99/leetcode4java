package offer2;

import Tree.TreeNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/17 19:26
 * @description 剑指 Offer II 049. 从根节点到叶节点的路径数字之和
 **/
public class sumNumbers_ {
    int res=0;
    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return res;
    }
    private void dfs(TreeNode root,int cur){
        if (root==null){
            return;
        }
        cur=cur*10+root.val;
        if (root.left==null&&root.right==null){
            res+=cur;
        }else{
            dfs(root.left,cur);
            dfs(root.right,cur);
        }
    }
}
