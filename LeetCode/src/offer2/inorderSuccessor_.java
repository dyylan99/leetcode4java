package offer2;

import HotOneHundred.ListNode;
import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/19 14:32
 * @description TODO
 **/
public class inorderSuccessor_ {
    List<TreeNode>list=new ArrayList<>();
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p==null){
            return null;
        }
        traverse(root,p);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)==p&&i!=list.size()-1){
                return list.get(i+1);
            }
        }
        return null;
    }

    private void traverse(TreeNode root,TreeNode p){
        if (root==null){
            return ;
        }
        traverse(root.left,p);
        list.add(root);
        traverse(root.right,p);
    }

    public TreeNode inorderSuccessor1(TreeNode root,TreeNode p){
        TreeNode res=null;

        while (root!=null){
            if (root.val>p.val){
                res=root;
                root=root.left;
            }else{
                root=root.right;
            }
        }
        return res;
    }
}
