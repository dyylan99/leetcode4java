package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/11 18:44
 * @description 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * 111. 二叉树的最小深度
 **/
public class minDepth_ {
    public int minDepth(TreeNode root) {
        //采用递归,每递归一次层数加一
        if(root==null){
            return 0;
        }
       if(root.left!=null&&root.right==null){
           return 1+minDepth(root.left);
       }
       if(root.left==null&&root.right!=null){
           return 1+minDepth(root.right);
       }
       return Math.min(minDepth(root.right),minDepth(root.left))+1;
    }
    //迭代法:
    public int minDepth1(TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return 0;
        }
        q.add(root);
        int deep=1;
        while(!q.isEmpty()){
            int size=q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur=q.remove();
                if(cur.left!=null){
                    q.add(cur.left);
                }
                if(cur.right!=null){
                    q.add(cur.right);
                }

                if(cur.left==null&&cur.right==null){
                    return deep;
                }
            }
            deep++;
        }
        return deep;
    }

}
