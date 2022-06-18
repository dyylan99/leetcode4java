package TreeTrain;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/6/10 8:58
 * @description 求给定二叉树的最大深度，
 * 深度是指树的根节点到任一叶子节点路径上节点的数量。
 * 最大深度是所有叶子节点的深度的最大值。
 * （注：叶子节点是指没有子节点的节点。）
 **/
public class maxdepth {
    public int maxDepth (TreeNode root) {
        /**
         * 递归方法
         */
        if(root == null){
            return 0;
        }
      return Math.max(maxDepth(root.right),maxDepth(root.left))+1;

    }

    public int maxDepth1 (TreeNode root){
        /**
         * 使用层序遍历:
         * 借助queue
         */
        if(root==null){
            return 0;
        }
        int result=0;
        Queue<TreeNode>q=new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            for (int i = 0; i <n ; i++) {
                TreeNode r = q.remove();
                if(r.left!=null) {
                    q.add(r.left);
                }
                if(r.right!=null) {
                    q.add(r.right);
                }
            }
            result++;
        }
            return result;


    }


}
