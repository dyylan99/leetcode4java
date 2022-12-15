package DynamicPrograming;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/15 14:51
 * @description 背包问题概述
 **/
public class testWeightBagProblem_ {
    public static void testWeightBagProblem(int[] weight, int[] value, int bagWeight){
        int wLen=weight.length;
        //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        int[]dp=new int[bagWeight+1];
        for (int i = 0; i < wLen; i++) {
            for (int j = bagWeight; j>=weight[i]; j--) {
                dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
                System.out.println("dp["+j+"]="+dp[j]);
            }
        }
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWight = 4;
        testWeightBagProblem(weight, value, bagWight);
    }
}
