package offer2;

import Tree.TreeNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/18 14:10
 * @description TODO
 **/
public class increasingBST_ {
    TreeNode res;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy=new TreeNode(-1);
        res=dummy;
        middleTraverse(root);
        return dummy.right;
    }

    public void middleTraverse(TreeNode cur){
        if (cur==null){
            return ;
        }

        //左
        middleTraverse(cur.left);
        //中
        res.right=cur;
        cur.left=null;
        res=cur;
        //右
        middleTraverse(cur.right);
    }
}
