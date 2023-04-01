package offer;

import java.util.Arrays;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/1 14:59
 * @description 面试题61. 扑克牌中的顺子
 **/
public class isStraight_ {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]==0){
                count++;
                continue;
            }
            if(nums[i+1]-nums[i]==1){
                continue;
            }else if(nums[i+1]-nums[i]==0){
                return false;
            }else if(nums[i+1]-nums[i]<=count+1){
                int t=nums[i+1]-nums[i];
                for (int j = 0; j < t; j++) {
                    count--;
                }
            }else{
                return false;
            }
        }
        return true;

    }
}
