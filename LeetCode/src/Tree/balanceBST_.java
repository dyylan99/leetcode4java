package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/23 10:50
 * @description 给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。如果有多种构造方法，请你返回任意一种。
 *
 * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
 *
 * 1382. 将二叉搜索树变平衡
 **/
public class balanceBST_ {
    List<Integer>list=new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        if(root==null){
            return null;
        }
        traversal(root);
        return getTree(list,0,list.size()-1);
    }

    //中序遍历把搜索树转化为有序数组
    public void traversal(TreeNode node){
        if(node==null){
            return;
        }
        traversal(node.left);
        list.add(node.val);
        traversal(node.right);
    }

    //有序数组转化为平衡二叉搜索树
    public TreeNode getTree(List<Integer>list,int left,int right){
        if(left>right){
            return null;
        }
        int mid=left+((right-left)/2);
        TreeNode root=new TreeNode(list.get(mid));
        root.left=getTree(list,left,mid-1);
        root.right=getTree(list,mid+1,right);
        return root;
    }
}
