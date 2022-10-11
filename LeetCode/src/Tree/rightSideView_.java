package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/11 15:49
 * @description 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 199. 二叉树的右视图
 **/
public class rightSideView_ {
    public List<Integer> rightSideView(TreeNode root) {
        /**
         * 思路:层序遍历时, 判断是否到达每一层的最后一个元素, 若到达则存到结果数组中返回
         * 建议借助队列使用迭代法
         *
         */
        List<Integer>list=new ArrayList<>();
        if (root==null){
            return  list;
        }
        Queue<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
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
                if(i==len-1){
                    list.add(remove.val);
                }
            }
        }
        return list;
    }
}
