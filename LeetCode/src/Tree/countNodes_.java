package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/13 11:32
 * @description 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *222. 完全二叉树的节点个数
 **/
public class countNodes_ {
    //迭代法:
    //借助队列层序遍历,再记录节点数
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode>q=new ArrayDeque<>();
        q.add(root);
        int res=0;
        while (!q.isEmpty()){
            int len=q.size();
            for (int i = 0; i < len; i++) {
                TreeNode remove = q.remove();
                if(remove.left!=null){
                    q.add(remove.left);
                }
                if(remove.right!=null){
                    q.add(remove.right);
                }
            }
            res+=len;
        }
        return res;
    }
    //递归法:
    public int countNodes1(TreeNode root){
        if (root==null){
            return 0;
        }
        return countNodes1(root.left)+countNodes1(root.right)+1;

    }
    /**
     * 以上两种解法都是当做普通二叉树来做的,并未利用完全二叉树的特性:
     * 完全二叉树只有两种情况，情况一：就是满二叉树，情况二：最后一层叶子节点没有满。
     * 对于情况一，可以直接用 2^树深度 - 1 来计算，注意这里根节点深度为1。
     *
     * 对于情况二，分别递归左孩子，和右孩子，递归到某一深度一定会有左孩子或者右孩子为满二叉树，然后依然可以按照情况1来计算。
     * 这里关键在于如果去判断一个左子树或者右子树是不是满二叉树呢？
     *
     * 在完全二叉树中，如果递归向左遍历的深度等于递归向右遍历的深度，那说明就是满二叉树。
     */
    //获取完全二叉树的深度
    public int getDepth(TreeNode root){
        int depth=0;
        while (root!=null){
            root=root.left;
            depth++;
        }
        return depth;
    }
    public int countNodes2(TreeNode root){
            if (root==null){
                return 0;
            }
            int leftDepth=getDepth(root.left);
            int rightDepth=getDepth(root.right);
            // 满二叉树的结点数为：2^depth - 1
            //左子树是满二叉树
            if(leftDepth==rightDepth){
                // 2^leftDepth其实是 （2^leftDepth - 1） + 1 ，左子树 + 根结点
                return (1<<leftDepth)+countNodes2(root.right);
            }else{
                return (1<<rightDepth)+countNodes2(root.left);
            }
    }


}
