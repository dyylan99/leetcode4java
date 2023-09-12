package cn.dylan.Tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/11 14:00
 * @description TODO
 **/
public class levelOrder_ {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>res=new ArrayList<>();
        if (root==null){
            return res;
        }
        Queue<TreeNode>q=new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()){
            List<Integer>level=new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left!=null){
                    q.add(node.left);
                }
                if (node.right!=null){
                    q.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
