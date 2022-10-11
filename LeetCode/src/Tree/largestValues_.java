package Tree;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/11 16:28
 * @description 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 * 515. 在每个树行中找最大值
 **/
public class largestValues_ {
    public List<Integer> largestValues(TreeNode root) {
        /**
         * 思路:
         * 借助队列采用层序遍历,遍历的每一层的值都用数组存储起来,最后取出最大值放入结果数组中
         */
        List<Integer>res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> q=new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()){
            List<Integer>list=new ArrayList<>();
            int len=q.size();
            for (int i = 0; i < len; i++) {
                TreeNode remove = q.remove();
                if(remove.left!=null){
                    q.add(remove.left);
                }
                if(remove.right!=null){
                    q.add(remove.right);
                }
                list.add(remove.val);
            }
            Integer max = Collections.max(list);
            res.add(max);
        }
        return res;
    }
}
