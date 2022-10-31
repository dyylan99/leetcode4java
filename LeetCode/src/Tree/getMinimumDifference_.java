package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/18 16:02
 * @description 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 差值是一个正数，其数值等于两值之差的绝对值。
 *530. 二叉搜索树的最小绝对差
 **/
public class getMinimumDifference_ {
    private TreeNode pre=null;
    int result=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        inorderTra(root,list);
        int res=list.get(1)-list.get(0);
        for (int i = 1; i < list.size()-1; i++) {
            if(res>list.get(i+1)-list.get(i)){
                res=list.get(i+1)-list.get(i);
            }
        }
        return res;
    }
    public void inorderTra(TreeNode root, List<Integer> list){
        /**
         * 第一种最简单的写法:
         *  中序遍历bst,然后依据结果是有序数组求得答案
         */
        if(root==null){
            return;
        }
        inorderTra(root.left,list);
        list.add(root.val);
        inorderTra(root.right,list);
    }

    /**
     * 递归:
     * 依然采用中序遍历,但是需要一个全局变量记录前一个节点
     */
    void traversal(TreeNode root){
        if(root==null){
            return;
        }
        traversal(root.left);
        if(pre!=null){
            result=Math.min(result,root.val-pre.val);
        }
        pre=root;
        traversal(root.right);
    }

}
