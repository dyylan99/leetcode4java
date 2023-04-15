package offer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/11 20:02
 * @description TODO
 **/
public class threeSum_ {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                break;
            }
            //去重
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int j=i+1;
            int k=nums.length-1;
            while (j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }else {
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    //去重
                    while (j<k&&nums[j]==nums[j+1]){
                        j++;
                    }
                    while (j<k&&nums[k]==nums[k-1]){
                        k--;
                    }
                    j++;
                    k--;
                }

            }
        }
        return res;
    }
}
