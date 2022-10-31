package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/31 15:13
 * @description 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * 108. 将有序数组转换为二叉搜索树
 **/
public class sortedArrayToBST_ {

    public TreeNode sortedArrayToBST(int[] nums) {
        return traversal(nums,0,nums.length-1);
    }
    /**
     * 递归
     */
    public TreeNode traversal(int []nums,int left,int right){
        if(left>right){
            return null;
        }
        int mid=left+((right-left)/2);
        TreeNode midNode=new TreeNode(nums[mid]);
        midNode.left=traversal(nums,left,mid-1);
        midNode.right=traversal(nums,mid+1,right);
        return midNode;
    }
    /**
     * 迭代
     * 使用三个队列来模拟:
     * 一个队列存放节点, 一个队列存放左下标, 一个节点存放右下标
     */
    public TreeNode sortedArrayToBST1(int[] nums){
        if(nums.length==0){
            return null;
        }
        TreeNode root=new TreeNode(0);
        Queue<TreeNode>nodeQueue=new ArrayDeque<>();
        Queue<Integer>leftQueue=new ArrayDeque<>();
        Queue<Integer>rightQueue=new ArrayDeque<>();
        nodeQueue.add(root);
        leftQueue.add(0);
        rightQueue.add(nums.length-1);
        while (!nodeQueue.isEmpty()){
            TreeNode cur=nodeQueue.poll();
            int left=leftQueue.poll();
            int right=rightQueue.poll();
            int mid=left+((right-left)/2);
            cur.val=nums[mid];
            if(left<=mid-1){
                cur.left=new TreeNode(0);
                nodeQueue.add(cur.left);
                leftQueue.add(left);
                rightQueue.add(mid-1);
            }
            if(right>mid+1){
                cur.right=new TreeNode(0);
                nodeQueue.add(cur.right);
                leftQueue.add(mid+1);
                rightQueue.add(right);
            }
        }
        return root;
    }

}
