package DoublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/16 13:55
 * @description 给你一个整数数组 nums ，
 * 判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 * 15. 三数之和
 **/
public class threeSum_ {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        if(nums.length<3){
            return res;
        }
        //给数组升序排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i]>0){
                return res;
            }
            //去重
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int left=i+1;
            int right=nums.length-1;
            while (left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if (sum==0){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    // 需要确定的一件事: i 在此层是不变的, 和也是不变的
                    //因此, 当nums[left]右移或者nums[right]左移时, 若他们的值其中有没变的, 那么三元组还是会重复
                    //因此, 需要去重
                    while (left<right&&nums[left]==nums[left+1]){
                        left++;
                    }
                    while (left<right&&nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum<0) {
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }
}
