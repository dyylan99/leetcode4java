package offer;

import Tree.TreeNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/19 13:11
 * @description 剑指 Offer 26. 树的子结构
 **/
public class isSubStructure_ {
    // 该函数返回以A为根节点的树是否含有B树的结构
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null || B == null){
            return false;
        }
        if(isSubTree(A, B)){
            return true;
        }
        return isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }
    // 该函数返回a,b树根节点一定 a是否含有b树的结构
    public boolean isSubTree(TreeNode a, TreeNode b){
        if(b == null ){
            return true;
        }
        if(a == null){
            return false;
        }
        if(a.val != b.val){
            return false;
        }
        return isSubTree(a.left,b.left) && isSubTree(a.right,b.right);
    }

}
