package DynamicPrograming;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/16 16:08
 * @description 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 *
 * 494. 目标和
 **/
public class findTargetSumWays_ {
    //假设加法的总和为x，那么减法对应的总和就是sum - x。
    //
    //所以我们要求的是 x - (sum - x) = target
    //
    //x = (target + sum) / 2
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for (int num : nums) {
            sum+=num;
        }
        if((sum+target)%2==1||(Math.abs(target)>sum)){
            return 0;
        }
        //dp[j] 表示：填满j（包括j）这么大容积的包，有dp[j]种方法
        int bagSize=(target+sum)/2;
        int[]dp=new int[bagSize+1];
        dp[0]=1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j>=nums[i]; j--) {
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[bagSize];
    }
}
