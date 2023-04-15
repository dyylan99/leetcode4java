package offer2;

import Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/15 22:12
 * @description 剑指 Offer II 045. 二叉树最底层最左边的值
 **/
public class findBottomLeftValue_ {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode>queue=new ArrayDeque<>();

        queue.add(root);
        int res=root.val;
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (i==0){
                    res=node.val;
                }
                if (node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        return res;
    }

}
