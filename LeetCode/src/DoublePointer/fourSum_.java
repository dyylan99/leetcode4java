package DoublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/16 14:38
 * @description 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 *18. 四数之和
 **/
public class fourSum_ {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>>res=new ArrayList<>();
        //将数组排序,排成升序
        Arrays.sort(nums);
        if(nums.length<4){
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            //nums[i]若为正数且大于目标数,则直接返回res
            if(nums[i]>0&&nums[i]>target){
                return res;
            }
                //当前元素若与前一个元素相同,则跳过,避免出现重复四元组
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            //以i为基数,j为第二个基数, index是靠近j的移动元素,right是靠近又边界的移动元素
            for (int j = i+1; j <nums.length; j++) {
                //当前元素若何前一个元素相同,则直接跳过,避免出现重复的四元组
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int index1=j+1;
                int right=nums.length-1;
                //左移动元素小于右移动元素
                while (index1<right){

                    int sum=nums[i]+nums[j]+nums[index1]+nums[right];
                    //sum大于就右边界左移
                    if(sum>target){
                        right--;
                        //小于就右移
                    }else if(sum<target){
                        index1++;
                    }else{
                        //相等的话就添加到结果中
                        res.add(Arrays.asList(nums[i],nums[j],nums[index1],nums[right]));
                        //index所在元素若等于index+1所在元素,就直接让index跳过index+1
                        while (index1<right&&nums[index1]==nums[index1+1]){
                            index1++;
                        }
                        //right所在元素若等于right-1所在元素,那么级直接跳过
                        while (index1<right&&nums[right]==nums[right-1]){
                            right--;
                        }
                        //index向前加一
                        index1++;
                        //right向后减一
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
