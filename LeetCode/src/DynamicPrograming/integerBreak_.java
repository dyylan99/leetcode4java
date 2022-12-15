package DynamicPrograming;

import org.junit.Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/14 15:37
 * @description 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 *
 * 返回 你可以获得的最大乘积 。
 *
 * 343. 整数拆分
 **/
public class integerBreak_ {
    public int integerBreak(int n) {
        int[]dp=new int[n+1];
        dp[2]=1;
        for (int i = 3; i <=n; i++) {
            for(int j=1;j<=i-j;j++){ //dp[i]就代表着i被拆分的数的最大积
                dp[i]=Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }
        }
        return dp[n];
    }

    @Test
    public void test(){
        System.out.println(integerBreak(10));
    }


    //数学解法
    public int integerBreak1(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int result = 1;
        while (n > 4) {
            result *= 3;
            n -= 3;
        }
        result *= n;
        return result;
    }
}
