package HotOneHundred;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/14 12:53
 * @description TODO
 * 560. 和为 K 的子数组
 **/
public class subarraySum_ {
    public int subarraySum1(int[] nums, int k) {
        /**
         * 前缀和
         */
        int[] preSum=new int[nums.length+1];
        preSum[0]=0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i+1]=preSum[i]+nums[i];
        }
        int count=0;
        for (int left = 0; left < nums.length; left++) {
            for (int right = left; right <nums.length ; right++) {
                if(preSum[right+1]-preSum[left]==k){
                    count++;
                }
            }
        }
        return count;
    }
    public int subarraySum(int[] nums, int k) {
        // key：前缀和，value：key 对应的前缀和的个数
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        preSumFreq.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;

            // 先获得前缀和为 preSum - k 的个数，加到计数变量里
            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }

            // 然后维护 preSumFreq 的定义
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
    @Test
    public void test(){
        subarraySum(new int[]{1,2,3,5,6,7,4,3},14);
    }
}
