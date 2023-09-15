package cn.dylan.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/14 19:19
 * @description 105. 从前序与中序遍历序列构造二叉树
 **/
public class buildTree_ {
    Map<Integer,Integer>map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i );
        }
        return help(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    //左闭,右闭区间
    private TreeNode help(int[]preorder,int pl,int pr, int[]inorder,int il, int ir){
        if (pl>pr || il>ir){
            return null;
        }
        Integer index = map.get(preorder[pl]);
        TreeNode root=new TreeNode(inorder[index]);
        //头结点在中序遍历数组的下标
        //左子树的长度:
        int leftLength=index-il;
        root.left=help(preorder,pl+1,pl+leftLength,inorder,il,index-1);

        root.right=help(preorder,pl+leftLength+1,pr,inorder,index+1,ir);
        return root;

    }
}
