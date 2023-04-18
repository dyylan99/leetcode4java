package offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/18 13:34
 * @description 乘积小于k的子数组
 **/
public class numSubarrayProductLessThanK_ {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k==0){
            return 0;
        }
        int res=0;
        int left=0;
        int right=0;
        int product=1;
        while (right<nums.length){
            product*=nums[right];
            right++;
            if (product<k){
                res+=right-left;
            }else{
                while (left<right&&product>=k){
                    product/=nums[left];
                    left++;
                }
                res+=right-left;
            }
        }
        return res;
    }
}
