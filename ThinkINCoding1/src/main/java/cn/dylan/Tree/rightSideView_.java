package cn.dylan.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/11 14:47
 * @description 199. 二叉树的右视图
 **/
public class rightSideView_ {
    //层序遍历, 返回每层最后一个
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>res=new ArrayList<>();
        if (root==null){
            return res;
        }
        Queue<TreeNode>q=new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left!=null){
                    q.add(node.left);
                }
                if (node.right!=null){
                    q.add(node.right);
                }
                if (i==size-1){
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}
