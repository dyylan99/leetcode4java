package offer;

import Tree.TreeNode;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/20 13:16
 * @description TODO
 **/
public class levelOrder_ {
    public int[] levelOrder(TreeNode root) {
        if(root==null){
            return new int[]{};
        }
        List<Integer>list=new ArrayList<>();
        Queue<TreeNode>queue=new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode remove = queue.remove();
            list.add(remove.val);
            if(remove.left!=null){
                queue.add(remove.left);
            }
            if(remove.right!=null){
                queue.add(remove.right);
            }
        }
        int[] res=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        return res;
    }
}
