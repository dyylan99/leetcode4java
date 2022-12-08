package Greed;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/8 11:09
 * @description 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 *
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 *
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 *
 * 1005. K 次取反后最大化的数组和
 **/
public class largestSumAfterKNegations_ {
    //使用流的方法
    public int largestSumAfterKNegations1(int[] nums, int k) {
        nums= IntStream.of(nums)
                .boxed()
                .sorted((a,b)-> Math.abs(b)-Math.abs(a)).mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<0&&k>0){
                nums[i]=-nums[i];
                k--;
            }
        }
        if(k%2==1)nums[nums.length-1]=-nums[nums.length-1];
        return Arrays.stream(nums).sum();
    }
    //不使用流的方法
    public int largestSumAfterKNegations(int[] nums, int k){
        if(nums.length==1){
            return k%2==0?nums[0] :-nums[0];
        }
        Arrays.sort(nums);
        int idx=0;
        for (int i = 0; i < k; i++) {
            if(i<nums.length-1&&nums[idx]<0){
                nums[idx]=-nums[idx];
                if(nums[idx]>=Math.abs(nums[idx+1])){
                    idx++;
                }
                continue;
            }
            nums[idx]=-nums[idx];
        }
        int sum=0;
        for (int num : nums) {
            sum+=num;
        }
        return sum;
    }
}
