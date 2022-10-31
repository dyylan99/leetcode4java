package Tree;

import com.sun.source.tree.Tree;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/17 19:11
 * @description 给定一个不重复的整数数组nums 。最大二叉树可以用下面的算法从nums 递归地构建:
 *
 * 创建一个根节点，其值为nums 中的最大值。
 * 递归地在最大值左边的子数组前缀上构建左子树。
 * 递归地在最大值 右边 的子数组后缀上构建右子树。
 * 返回nums 构建的 最大二叉树 。
 *
 * 654. 最大二叉树
 *
 **/
public class constructMaximumBinaryTree_ {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return traversal(nums,0,nums.length);
    }
    public TreeNode traversal(int[] nums,int left, int right){
        if(left>right){
            return null;
        }
        //找到分割点下标
        int maxValueIndex=left;
        for (int i = left+1; i < right; i++) {
            if(nums[i]>nums[maxValueIndex]){
                maxValueIndex=i;
            }
        }
        //根据找到的最大值分割点构建二叉树节点
        TreeNode root=new TreeNode(nums[maxValueIndex]);

        //
        root.left=traversal(nums,left,maxValueIndex);
        root.right=traversal(nums,maxValueIndex+1,right);
        return root;
    }

}
