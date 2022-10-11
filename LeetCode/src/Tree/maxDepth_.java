package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/11 18:29
 * @description 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 104. 二叉树的最大深度
 **/
public class maxDepth_ {
    /**
     * 直接使用层序遍历
     */
    public int maxDepth(TreeNode root) {
        //采用递归,每递归一次层数加一
        return level(0,root);
    }
    public int level(int deep, TreeNode root){
        if(root==null){
            return deep;
        }
        deep++;
        return Math.max(level(deep,root.left), level(deep,root.right));
    }
    //迭代版本
    public int maxDepth1(TreeNode root) {
        if (root == null)   return 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int depth = 0;
        while (!que.isEmpty())
        {
            int len = que.size();
            while (len > 0)
            {
                TreeNode node = que.poll();
                if (node.left != null)  que.offer(node.left);
                if (node.right != null) que.offer(node.right);
                len--;
            }
            depth++;
        }
        return depth;
    }
}
