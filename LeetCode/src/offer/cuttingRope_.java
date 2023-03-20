package offer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/17 12:51
 * @description 剑指 Offer 14- I. 剪绳子
 *
 * 分解整数,去除最大乘积
 **/
public class cuttingRope_ {
    public int cuttingRope(int n) {
        //动态规划
        if(n==1||n==0){
            return n;
        }
        int[]dp=new int[n+1];
        dp[2]=1;

        for (int i = 3; i <=n ; i++) {
            for (int j = 1; j <=i/2 ; j++) {
                dp[i]=Math.max(dp[i],Math.max((i-j)*j,dp[i-j]*j));
            }
        }
        return dp[n];
    }
}
