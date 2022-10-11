package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/11 15:19
 * @description TODO
 * 102. 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 **/
public class levelOrder_ {
    public List<List<Integer>> levelOrder(TreeNode root) {
        /**
         层序遍历思路:
         采用数组收集每一层的节点;
         获取数组的长度,遍历;
         将每一层的数据放在双数组中
         */

        List<List<Integer>>list=new ArrayList<>();
        //  if(root==null){
        //      return list;
        //  }
        // Queue<TreeNode>queue=new LinkedList<>();
        // queue.add(root);
        // while(!queue.isEmpty()){
        //     List<Integer>list1=new ArrayList<>();
        //     int len=queue.size();
        //     for(int i=0;i<len;i++){
        //         TreeNode node=queue.remove();
        //         if(node.left!=null){
        //             queue.offer(node.left);
        //         }
        //         if(node.right!=null){
        //             queue.offer(node.right);
        //         }
        //         list1.add(node.val);
        //     }
        //     list.add(list1);
        // }
        // return list;
        levelOrder1(root,0,list);
        return list;
    }
    //递归版本
    public void levelOrder1(TreeNode root,int deep, List<List<Integer>>list){
        //确定结束条件
        if(root==null){
            return;
        }
        //每递归一次深度加一
        deep++;
        if(list.size()<deep){
            List<Integer>l=new ArrayList<>();
            list.add(l);
        }
        list.get(deep-1).add(root.val);
        levelOrder1(root.left,deep,list);
        levelOrder1(root.right,deep,list);
    }

}

