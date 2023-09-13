package cn.dylan.Array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/12 16:23
 * @description 18. 四数之和
 **/
public class fourSum_ {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>>res=new ArrayList<>();
        int n=nums.length;
        int left=0, right=n-1;
        if (right-left<3){
            return res;
        }
        for (int i = left; i < n-3; i++) {
            //排除第一个元素重复的情况
            if (i>left&& nums[i]==nums[i-1]){
                continue;
            }
            for (int b = i+1; b <n-2 ; b++) {
                if (b>i+1&&nums[b]==nums[b-1]){
                    continue;
                }
                int c=b+1,d=right;
                while (c<d){
                    //考虑数据溢出的情况
                    long sum=(long)nums[i]+(long)nums[b]+(long)nums[c]+(long)nums[d];
                    if (sum>target){
                        d--;
                    }else if (sum<target){
                        c++;
                    }else{
                        res.add(Arrays.asList(nums[i],nums[b],nums[c],nums[d]));
                        while (c<d&& nums[d]==nums[d-1]){
                            d--;
                        }
                        while (c<d&&nums[c]==nums[c+1]){
                            c++;
                        }
                        d--;
                        c++;
                    }
                }

            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11));

    }
}
