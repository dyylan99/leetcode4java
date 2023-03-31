package offer;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/27 16:50
 * @description 剑指 Offer 54. 二叉搜索树的第k大节点
 **/
public class kthLargest_ {
    int res;
    public  int count=0;
    public int kthLargest(TreeNode root, int k) {
        //二叉搜索树的伪中序遍历
        traverse(root,k);
        return res;

    }

    private void traverse(TreeNode cur,int k){
        if (cur==null){
            return;
        }
        traverse(cur.right,k);
        if(++count==k){
            res=cur.val;
        }
        traverse(cur.left,k);
    }
}
