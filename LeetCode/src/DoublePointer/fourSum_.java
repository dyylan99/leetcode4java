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
        Arrays.sort(nums);

        if(nums.length<4){
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0&&nums[i]>target){
                return res;
            }
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }

            for (int j = i+1; j <nums.length; j++) {
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int index1=j+1;
                int right=nums.length-1;
                while (index1<right){
                    int sum=nums[i]+nums[j]+nums[index1]+nums[right];
                    if(sum>target){
                        right--;
                    }else if(sum<target){
                        index1++;
                    }else{
                        res.add(Arrays.asList(nums[i],nums[j],nums[index1],nums[right]));
                        while (index1<right&&nums[index1]==nums[index1+1]){
                            index1++;
                        }
                        while (index1<right&&nums[right]==nums[right-1]){
                            right--;
                        }
                        index1++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
