package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/13 13:07
 * @description 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 * 257. 二叉树的所有路径
 **/
public class binaryTreePaths_ {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>res=new ArrayList<>();
        if(root==null){
            return res;
        }
        List<Integer>paths=new ArrayList<>();
        traversal(root,paths,res);
        return res;
    }
    /**
     * 本题涉及到回溯,所以优先考虑递归
     * 确定递归参数:
     *  需要传入根节点, 记录每一条路径的字符串, 以及最终的结果数组
     */
    void traversal(TreeNode cur,List<Integer>path,List<String>res){
        /**
         * 停止条件:找到树叶节点
         *
         */
        path.add(cur.val);
        //叶子结点
        if(cur.right==null&&cur.left==null){
            StringBuilder sPath=new StringBuilder();
            for (int i = 0; i < path.size()-1; i++) {
                sPath.append(path.get(i)).append("->");
            }
            sPath.append(path.get(path.size()-1));
            res.add(sPath.toString());
        }
        if(cur.left!=null){
            traversal(cur.left,path,res);
            //回溯,添加完该节点的路径就将其删除
            path.remove(path.size()-1);
        }
        if(cur.right!=null){
            traversal(cur.right,path,res);
            path.remove(path.size()-1);
        }
    }
    /**
     * 迭代法
     */
    public List<String> binaryTreePaths1(TreeNode root){
        List<String>res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Stack<Object>s1=new Stack<>();
        //节点和路径同时入栈
        s1.push(root);
        s1.push(root.val+"");
        while(!s1.empty()){
            //节点和路径同时出栈
            String path=(String) s1.pop();
            TreeNode node=(TreeNode) s1.pop();
            //若找到叶子结点
            if(node.right==null&&node.left==null){
                res.add(path);
            }
            //若右节点不为空
            if(node.right!=null){
                s1.push(node.right);
                s1.push(path+"->"+node.right.val);
            }
            //若左节点不为空
            if(node.left!=null){
                s1.push(node.left);
                s1.push(path+"->"+node.left.val);
            }
        }
        return res;
    }
}
