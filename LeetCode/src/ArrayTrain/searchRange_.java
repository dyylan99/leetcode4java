package ArrayTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/26 13:48
 * @description 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 **/
public class searchRange_ {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0){
            return new int[]{-1,-1};
        }
        int left=0;
        int right=nums.length-1;

        while (left<=right){
            int middle=(left+right)/2;
            if(nums[middle]>target){
                right=middle-1;
            }else if(nums[middle]<target){
                left=middle+1;
            }else{
                left=middle;
                right=middle;
                while (left>=0&&nums[left]==target){
                    left--;
                }
                while (right<nums.length&&nums[right]==target){
                    right++;
                }
                return new int[]{left+1,right-1};
            }
        }
        return new int[]{-1,-1};
    }
}
