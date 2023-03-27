package offer;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/21 16:01
 * @description 剑指 Offer 34. 二叉树中和为某一值的路径
 **/
public class pathSum_ {
    List<List<Integer>>res=new ArrayList<>();
    List<Integer>path=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        backTracking(root,target,0);
        return res;
    }

    private void backTracking(TreeNode cur, int target,int num){
        if(cur==null){
            return;
        }
        //叶子结点
        if (cur.right==null&&cur.left==null){
            num+= cur.val;
            if(num==target){
                path.add(cur.val);
               res.add(new ArrayList<>(path));
            }
            return;
        }
        //不是叶子结点
        path.add(cur.val);
        backTracking(cur.left,target,num+cur.val);
        backTracking(cur.right,target,num+cur.val);
        path.remove(path.size()-1);
    }
}
