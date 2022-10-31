package Tree;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/17 17:47
 * @description 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树
 *106. 从中序与后序遍历序列构造二叉树
 **/
public class buildTree_ {

        Map<Integer,Integer>map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map=new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return treeBuild2(inorder,0,inorder.length,postorder,0,postorder.length);
    }

    /**
     * 版本一
     *思路:
     *  利用后序数组的最后一位元素找到根节点,然后利用根节点将中序数组分割,再利用分割的结果去分割后序数组
     */
    public TreeNode treeBuild(int [] inorder,int inBegin, int inEnd,int[] postorder,int postBegin, int postEnd){
        if(inBegin>=inEnd || postBegin>=postEnd){
            return null;
        }
        //找到分割根元素的值
        int inValue=postorder[postEnd-1];
        //找到根节点在中序数组中的下标
        int inValueIndex=0;

        for (int i = inBegin; i <inorder.length ; i++) {
            if(inValue==inorder[i]){
                inValueIndex=i;
            }
        }
        //保存中序左子树长度用来确定后续数组的分数组的长度
        int inLeftLength=inValueIndex-inBegin;
        //构造节点
        TreeNode root=new TreeNode(inValue);
        root.left=treeBuild(inorder,inBegin,inValueIndex,postorder,postBegin,postBegin+inLeftLength);
        root.right=treeBuild(inorder,inValueIndex+1,inEnd,postorder,postBegin+inLeftLength,postEnd-1);
        return root;
    }

    /**
     * 由于版本一每一次递归都会遍历中序数组,效率太低,可以借助全局变量map存中序数组里的值和index
     */
    public TreeNode treeBuild2(int [] inorder,int inBegin, int inEnd,int[] postorder,int postBegin, int postEnd){
        if(inBegin>=inEnd || postBegin>=postEnd){
            return null;
        }
        //找到分割根元素的值
        int inValue=postorder[postEnd-1];
        //找到根节点在中序数组中的下标
        int inValueIndex=map.get(inValue);

        //保存中序左子树长度用来确定后续数组的分数组的长度
        int inLeftLength=inValueIndex-inBegin;
        //构造节点
        TreeNode root=new TreeNode(inValue);
        root.left=treeBuild(inorder,inBegin,inValueIndex,postorder,postBegin,postBegin+inLeftLength);
        root.right=treeBuild(inorder,inValueIndex+1,inEnd,postorder,postBegin+inLeftLength,postEnd-1);
        return root;
    }



}
