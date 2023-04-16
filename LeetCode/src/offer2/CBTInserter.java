package offer2;

import Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/16 16:12
 * @description 剑指 Offer II 043. 往完全二叉树添加节点
 **/
public class CBTInserter {

    TreeNode root;
    Queue<TreeNode>queue=new ArrayDeque<>(); //存放左右子树不全的节点
    public CBTInserter(TreeNode root) {
        this.root=root;

        queue.add(root);
        while (queue.peek().left!=null&&queue.peek().right!=null){
            //左右子节点都有,弹出
            TreeNode node = queue.remove();
            queue.add(node.left);
            queue.add(node.right);
        }
    }

    //往完全二叉树中插入节点并返回新插入节点的父节点
    public int insert(int v) {
        TreeNode newNode=new TreeNode(v);

        TreeNode node = queue.peek();
        if (node.left==null){
            node.left=newNode;
        }else {
            node.right=newNode;
            //右子树填上后,该节点也需要被弹出
            queue.remove();
            queue.add(node.left);
            queue.add(node.right);
        }
        return node.val;

    }

    public TreeNode get_root() {
        return root;
    }
}
