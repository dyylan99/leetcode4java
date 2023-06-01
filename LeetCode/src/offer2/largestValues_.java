package offer2;

import TreeTrain.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/5/4 23:38
 * @description 剑指 Offer II 044. 二叉树每层的最大值
 **/
public class largestValues_ {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer>res=new ArrayList<>();
        if (root==null){
            return res;
        }
        Queue<TreeNode>q=new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()){
            int size=q.size();
            int max=Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left!=null){
                    q.add(node.left);
                }
                if (node.right!=null){
                    q.add(node.right);
                }
                max=Math.max(max,node.val);
            }
            res.add(max);
        }

        return res;
    }
}
