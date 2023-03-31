package offer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/28 14:50
 * @description 剑指 Offer 57. 和为s的两个数字
 **/
public class twoSum_ {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length==1){
            return new int[]{};
        }
        /**
         * 双指针
         */
        int l=0,r=nums.length-1;
        while (r>l){
            int tmp=nums[l]+nums[r];
            if(target==tmp){
                return new int[]{nums[l],nums[r]};
            }else if(tmp>target){
                r--;
            }else{
                l++;
            }
        }
        return new int[]{};
    }
}
