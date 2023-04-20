package offer2;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/20 14:17
 * @description 剑指 Offer II 008. 和大于等于 target 的最短子数组
 **/
public class minSubArrayLen_ {
    public int minSubArrayLen(int target, int[] nums) {

        int length=Integer.MAX_VALUE;
        int left=0;
        int right=0;
        int sum=0;
        while (right<nums.length){
            sum+=nums[right];
            while (left<=right&&sum>=target){
                length=Math.min(length,right-left+1);
                sum-=nums[left];
                left++;
            }
            right++;
        }

        return length==Integer.MAX_VALUE?0:length;
    }
}
