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

        //给数组升序
        Arrays.sort(nums);
        List<List<Integer>>res=new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if(nums[i]>0){
                return res;
            }
            //当前元素和前一个元素相等,就直接跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //index是i右边的移动元素
            int index=i+1;
            int right=nums.length-1;
         while (right>index){

             int sum=nums[i]+nums[index]+nums[right];

             if (sum>0){
                 right--;
             }else if(sum<0){
                 index++;
             }else{
                 //去重逻辑和四数之和相同
                res.add(Arrays.asList(nums[i],nums[right],nums[index]));
                 while (right > index && nums[right] == nums[right - 1]) right--;
                 while (right > index && nums[index] == nums[index + 1]) index++;

                 right--;
                 index++;
             }
         }
        }
        return res;
    }
}
