package TreeTrain;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/6/9 8:45
 * @description 给定一个二叉树，返回该二叉树层序遍历的结果，
 * （从左到右，一层一层地遍历）
 **/
public class levelOrder {
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        if(root==null){
            return null;
        }
        /**
         * 思路:借助队列,每次进入一层,统计队列中的节点个数
         * 遍历完之后,将其从队列中弹出,并将节点的子节点加入队列
         *
         */
        ArrayList<ArrayList<Integer>>res=new ArrayList<>();
        Queue<TreeNode>queue=new ArrayDeque<>();
        queue.add(root);
            while (!queue.isEmpty()) {
                ArrayList<Integer>list=new ArrayList<>();
                int n=queue.size();
                for (int i = 0; i < n; i++) {
                    TreeNode cur=queue.remove();
                    list.add(cur.val);
                    if(cur.left!=null){
                        queue.add(cur.left);
                    }
                    if(cur.right!=null){
                        queue.add(cur.right);
                    }
                }
                res.add(list);

        }

        return res;



    }
}

