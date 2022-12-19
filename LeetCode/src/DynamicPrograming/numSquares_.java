package DynamicPrograming;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/19 18:31
 * @description 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，
 *
 * 其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 **/
public class numSquares_ {
    //完全背包问题+组合数问题
    public int numSquares(int n) {
        //dp[i]代表完全平方数和为i的最小完全平方数个数
        //dp[i]=Math.min(dp[i],dp[i-j*j])
        //如果求组合数就是外层for循环遍历物品，内层for遍历背包。
        //
        //如果求排列数就是外层for遍历背包，内层for循环遍历物品。
        int max=Integer.MAX_VALUE;
        int[]dp=new int[n+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i]=max;
        }
        dp[0]=0;
        for (int i = 1; i*i <=n ; i++) {//遍历物品
            for (int j = i*i; j<=n ; j++) {//遍历背包
                dp[j]=Math.min(dp[j],dp[j-i*i]+1);
                System.out.println("i是:"+i+",j是:"+j+" dp[j]是: "+dp[j]);
            }
        }
        return dp[n];
    }
    @Test
    public void test(){
        numSquares(10);
    }
}
