package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/7/14 17:43
 * @description 230. 二叉搜索树中第K小的元素
 **/
public class kthSmallest_ {
    private List<Integer>list=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        /**
         * 二叉搜索树的特性: 二叉搜索树的中序遍历是有序的
         */
        inorder(root);
        return list.get(k-1);
    }
    private void inorder(TreeNode root){
        if (root==null){
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }



    //没有利用到二叉搜索树的特性: 这个针对于一般的二叉树可以使用
    public int kthSmallest1(TreeNode root, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        preTraverse(root,pq);
        for (int i = 0; i < k-1; i++) {
            pq.poll();
        }
        return pq.remove();
    }

    private void preTraverse(TreeNode root,PriorityQueue pq){
        if (root==null){
            return;
        }
        pq.add(root.val);
        preTraverse(root.left,pq);
        preTraverse(root.right,pq);
    }
}
