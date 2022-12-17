package DynamicPrograming;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/17 13:56
 * @description 有N件物品和一个最多能背重量为W的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。
 * 每件物品都有无限个（也就是可以放入背包多次），求解将哪些物品装入背包里物品价值总和最大。
 **/
public class CompleteBag_ {
    static void testCompletePack(){
        int[]weight=new int[]{1,3,4};
        int[]value=new int[]{15,20,30};
        int bagWeight=4;
        int[]dp=new int[bagWeight+1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j <= bagWeight; j++) {
                dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
        System.out.println(dp[bagWeight]);
    }

    public static void main(String[] args) {
        testCompletePack();
    }
}
