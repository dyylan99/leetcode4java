package offer;

import Tree.TreeNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/27 17:06
 * @description TODO
 **/
public class isBalanced_ {
    boolean flag=true;
    public boolean isBalanced(TreeNode root) {
        traverse(root);
        return flag;
    }

    //返回某个的最大节点深度
    private int traverse(TreeNode cur){
        if(cur==null){
            return 0;
        }
        int left=traverse(cur.left);
        int right=traverse(cur.right);
        if(Math.abs(left-right)>1){
            flag=false;
        }
        return Math.max(left,right)+1;

    }
}
