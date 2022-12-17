package DynamicPrograming;

import org.junit.Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/17 14:32
 * @description假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 一步一个台阶，两个台阶，三个台阶，.......，直到 m个台阶。问有多少种不同的方法可以爬到楼顶呢？
 *
 * //
 **/
public class climbStairs2__ {
    //完全背包问题+排列数问题
    public int climbStairs(int n,int m){
        int[]dp=new int[n+1];
        dp[0]=1;
        for (int i = 1; i <=n ; i++) {//遍历背包
            for (int j = 1; j <=m ; j++) {//遍历物品
                if(i-j>=0){
                    dp[i]+=dp[i-j];
                    System.out.println("i是:"+i+",dp["+i+"]"+"是:"+dp[i]);
                }
            }
        }
        return dp[n];
    }

    @Test
    public void test(){
        climbStairs(10,2);
    }

}
