package Tree;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/5 16:08
 * @description TODO
 **/
public class zigzagLevelOrder_ {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>res=new ArrayList<>();

        if(root==null){
            return res;
        }
        Queue<TreeNode>queue=new ArrayDeque<>();

        queue.add(root);
        boolean flag=false;
        while (!queue.isEmpty()){
          List<Integer>list=new LinkedList<>();

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);

                if(flag){
                    list.add(0,node.val);
                }else{
                    list.add(node.val);
                }
            }
            flag=!flag;
            res.add(list);
        }
        return res;

    }
}
