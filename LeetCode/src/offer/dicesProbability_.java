package offer;

import org.junit.Test;

import java.beans.beancontext.BeanContext;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/29 15:41
 * @description TODO
 **/
public class dicesProbability_ {
    public double[] dicesProbability(int n) {
        //直接使用动态规划：
        //思路：
        //定义 dp[i][j] 表示投了 i 个色子，点数为 j 的概率
        //现由投了 i-1 个色子来递推 i 的情况：，由于一个色子只能加数值 1-6,所以有以下情况：
        // dp[i-1][j-1],dp[i-1][j-2],...dp[i-1][j-k] (1<=k<=6)代表除去最后一个色子的点数的概率，而最后一个色子投任意数的概率为 1/6
        //所以有状态转移方程 dp[i][j] = (求和k从1到6) dp[i-1][j-k] * 1/6

        //n个色子投掷结果 [n,6n],共 5n+1个数
        double[] ans = new double[5 * n + 1];
        double[][] dp = new double[n + 1][6 * n + 1];

        //初始化
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1 / 6.0;
        }
        for (int i = 2; i <=n ; i++) {
            //i个筛子的点数范围: [i,6i]
            for (int j = i; j <=6*i ; j++) {
                for (int k = 1; k <=6 ; k++) {
                    if(j-k>0){
                        dp[i][j]+=dp[i-1][j-k]*1/6;
                    }else{
                        break;
                    }
                }
            }
        }
        //将二维数组等于n个色子的情况数值赋值给一维数组结果
        for (int i = 0; i < 5 * n + 1; i++) {
            //注意 dp的点数从 n开始算
            ans[i] = dp[n][n + i];
        }
        return ans;


    }
    @Test
    public void test(){

    }
}
