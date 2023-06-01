package Array;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/6/1 23:36
 * @description 代码随想录二刷: 数组:  在排序数组中查找元素的第一个和最后一个位置
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 **/
public class searchRange_ {
    public int[] searchRange(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if (nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                //找到了数值相同的位置
                left=mid;
                right=mid;
                while (left>=0&&nums[left]==target){
                    left--;
                }
                while (right<nums.length&&nums[right]==target){
                    right++;
                }
                return  new int[]{left+1,right-1};
            }
        }
        return new int[]{-1,-1};
    }
}
