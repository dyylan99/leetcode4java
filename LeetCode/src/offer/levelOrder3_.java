package offer;

import Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/20 13:36
 * @description 剑指 Offer 32 - III. 从上到下打印二叉树 III
 **/
public class levelOrder3_ {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>res=new ArrayList<>();
        if (root==null){
            return res;
        }
        Queue<TreeNode>queue=new ArrayDeque<>();
        queue.add(root);
        int count=1;
        while (!queue.isEmpty()){
            int len=queue.size();
            List<Integer>list=new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode remove = queue.remove();
                list.add(remove.val);
                if(remove.left!=null){
                    queue.add(remove.left);
                }
                if(remove.right!=null){
                    queue.add(remove.right);
                }
            }
            if(count%2==0){
                reverse(list);
            }
            res.add(list);
            count++;
        }
        return res;

    }

    private void reverse(List<Integer>list){
        if(list.size()==0||list.size()==1){
            return;
        }
        int left=0;
        int right=list.size()-1;
        while (left<right){
            int tem=list.get(left);
            list.set(left,list.get(right));
            list.set(right,tem);
            left++;
            right--;
        }
    }
}
