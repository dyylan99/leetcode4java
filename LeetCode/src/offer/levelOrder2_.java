package offer;

import Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/20 13:22
 * @description 剑指 Offer 32 - II. 从上到下打印二叉树 II
 **/
public class levelOrder2_ {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>>res=new ArrayList<>();
        if(root==null){
            return res;
        }

        Queue<TreeNode> queue=new ArrayDeque<>();
        Queue<TreeNode> NodeQueue=new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode remove = queue.remove();
            NodeQueue.add(remove);
           if(queue.isEmpty()){
               //一层遍历完了
               List<Integer>list=new ArrayList<>();
               while (!NodeQueue.isEmpty()){
                   TreeNode node = NodeQueue.remove();
                   list.add(node.val);
                   if(node.left!=null){
                       queue.add(node.left);
                   }
                   if(node.right!=null){
                       queue.add(node.right);
                   }
               }
               res.add(list);
           }
        }
        return res;
    }
    //队列size
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root==null) return new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            ArrayList<Integer> row = new ArrayList<>();

            for (int i=0; i<length; i++) {
                TreeNode node = queue.poll();
                row.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            list.add(row);
        }
        return list;
    }
}
