package DynamicPrograming;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/17 14:16
 * @description 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 *
 * 题目数据保证答案符合 32 位整数范围。
 *
 *377. 组合总和 Ⅳ
 **/
public class combinationSum4_ {
    //如果求组合数就是外层for循环遍历物品，内层for遍历背包。
    //如果求排列数就是外层for遍历背包，内层for循环遍历物品。
    public int combinationSum4(int[] nums, int target) {
        int[]dp=new int[target+1];
        dp[0]=1;
        for (int i = 0; i <=target; i++) {
            for (int j = 0; j <nums.length ; j++) {
              if (i-nums[j]>=0&&dp[i]<Integer.MAX_VALUE-dp[i-nums[j]]){
                  dp[i]+=dp[i-nums[j]];
              }
            }
        }
        return dp[target];
    }
}
