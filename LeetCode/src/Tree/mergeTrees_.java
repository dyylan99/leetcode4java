package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/18 14:21
 * @description 给你两棵二叉树： root1 和 root2 。
 *
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
 * 你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 *
 * 返回合并后的二叉树。
 *
 * 注意: 合并过程必须从两个树的根节点开始。
 * 617.合并二叉树
 **/
public class mergeTrees_ {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        /**
         * 迭代法
         */
        if(root1==null){
            return root2;
        }
        if(root2==null){
            return root1;
        }
        Queue<TreeNode>q1=new ArrayDeque<>();
        q1.add(root1);
        q1.add(root2);
        while (!q1.isEmpty()){
            TreeNode node1=q1.poll();
            TreeNode node2=q1.poll();
            node1.val=node1.val+node2.val;
            if(node1.left!=null&&node2.left!=null){
                q1.add(node1.left);
                q1.add(node2.left);
            }
            if(node1.right!=null&&node2.right!=null){
                q1.add(node1.right);
                q1.add(node2.right);
            }
            if(node1.left==null&&node2.left!=null){
                node1.left=node2.left;
            }
            if(node1.right==null&&node2.right!=null){
                node1.right=node2.right;
            }
        }
        return root1;
    }
    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        /**
         * 前序遍历两棵树,遍历的同时将各个节点的值相加构成新树
         */
        if(root1==null)
            return root2;
        if(root2==null)
            return root1;
       root1.val=root1.val+root2.val;                        //根节点
       root1.left=mergeTrees1(root1.left,root2.left);       //左节点
       root1.right=mergeTrees1(root1.right,root2.right);    //右节点
       return root1;
    }


}
