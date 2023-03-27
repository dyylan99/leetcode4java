package offer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/21 14:08
 * @description 剑指 Offer 42. 连续子数组的最大和
 **/
public class maxSubArray_ {
    public int maxSubArray(int[] nums) {
        int res=nums[0];
        for (int i = 1; i <nums.length ; i++) {
            nums[i]+=Math.max(nums[i-1],0);
            res=Math.max(res,nums[i]);
        }
        return res;
    }
}
