package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/11 15:41
 * @description 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 107. 二叉树的层序遍历 II
 **/
public class levelOrderBottom_ {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        /**
         * 思路一:
         * 直接按从上到下的方式层序遍历, 然后再将得到的结果反转
         */
        List<List<Integer>>list=new ArrayList<>();
        levelOrderBottom1(root,0,list);
        Collections.reverse(list);
        return list;

    }
    public void levelOrderBottom1(TreeNode root,int deep,List<List<Integer>>list){
        if(root==null){
            return;
        }
        //每次反转一次深度都加一
        deep++;
        if(list.size()<deep){
            List<Integer>list1=new ArrayList<>();
            list.add(list1);
        }
        list.get(deep-1).add(root.val);
        levelOrderBottom1(root.left,deep,list);
        levelOrderBottom1(root.right,deep,list);
    }
}
