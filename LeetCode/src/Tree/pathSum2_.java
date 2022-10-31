package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/14 13:32
 * @description 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 113. 路径总和 II
 **/
public class pathSum2_ {
    private List<List<Integer>>result;
    private LinkedList<Integer>path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>res=new ArrayList<>();
        if(root==null){
            return res;
        }
        List<Integer>path=new ArrayList<>();
        preorderdfs(root,res,path,targetSum);
        return res;
    }

    //递归版本一
    public void preorderdfs(TreeNode root,List<List<Integer>>res,List<Integer>path,int targetSum){
        path.add(root.val);
        //遇到了叶子节点
        if(root.left==null&&root.right==null){
            //若找到了和为targetSum的路径
            if(targetSum-root.val==0){
                res.add(new ArrayList<>(path));
            }
            return;
        }

        if(root.left!=null){
            preorderdfs(root.left,res,path,targetSum-root.val);
            //回溯
            path.remove(path.size()-1);
        }

        if(root.right!=null){
            preorderdfs(root.right,res,path,targetSum-root.val);
            //回溯
            path.remove(path.size()-1);
        }
    }
    /**
     * 递归版本二
     */
    public void preorderdfs2(TreeNode root,int tar){
        /**
         * 思路:
         *  遇到叶子结点做判断,若tar变为0则找到一条路线,若不为零则返回
         */
        if(root==null){
            return;
        }
        path.offer(root.val);
        tar-=root.val;
        if(root.left==null&&root.right==null&&tar==0){
            /**
             * 找到了符合的路线
             */
            result.add(new LinkedList<>(path));
        }
        /**
         * 若没遇到正确的线路则继续寻找:
         */
        preorderdfs2(root.left,tar);
        preorderdfs2(root.right,tar);
        path.removeLast();
    }

}
