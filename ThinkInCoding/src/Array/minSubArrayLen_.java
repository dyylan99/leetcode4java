package Array;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/7/14 16:56
 * @description 209. 长度最小的子数组
 *
 **/
public class minSubArrayLen_ {
    public int minSubArrayLen(int target, int[] nums){
        int res=Integer.MAX_VALUE;
        int length=nums.length;
        int left=0;
        int sum=0;
        for (int i = 0; i < length; i++) {
            sum+=nums[i];
            while (sum>=target){
                res=Math.min(res,i-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return res==Integer.MAX_VALUE? 0 : res;
    }
}
