package cn.dylan.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/12 16:12
 * @description 15. 三数之和
 **/
public class threeSum_ {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>res=new ArrayList<>();

        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i]>0){
                return res;
            }
            //因为每次到这一步都是选第一个元素, 所以如果和前面的元素重复了则直接跳过
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int left=i+1;
            int right=nums.length-1;
            while (left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if (sum>0){
                    right--;
                }else if(sum<0){
                    left++;
                }else{
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //此时, 排除第三个元素重复的情况
                    while (left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                    //此时 排除第二个元素重复的情况
                    while (left<right && nums[left]==nums[left+1]){
                        left++;
                    }
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
