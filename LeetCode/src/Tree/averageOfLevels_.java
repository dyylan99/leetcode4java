package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/11 15:58
 * @description 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 * 637. 二叉树的层平均值
 **/
public class averageOfLevels_ {

    public List<Double> averageOfLevels(TreeNode root) {
        /**
         * 思路:层序遍历二叉树的同时将每层结果相加,并记录节点数,最后的到的平均值加入到数组中
         */
        List<Double>list=new ArrayList<>();
        if (root==null){
            return  list;
        }
        Queue<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()){
            int len=q.size();
            double sum = 0;
            for (int i = 0; i < len; i++) {
                TreeNode remove = q.remove();
                if(remove.left!=null){
                    q.add(remove.left);
                }
                if(remove.right!=null){
                    q.add(remove.right);
                }
              sum+=remove.val;
            }
            list.add(sum/len);
        }
        return list;
    }
}
