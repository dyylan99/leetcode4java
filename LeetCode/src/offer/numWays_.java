package offer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/16 13:50
 * @description TODO
 **/
public class numWays_ {
    public int numWays(int n) {
        //dp[n]=dp[n-1]+dp[n-2]
        //dp[1]=1
        //dp[2]=2
        //dp[0]=0
        if(n==0||n==1){
            return n;
        }
        int[]dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <= n; i++) {
            dp[i]=(dp[i-1]+dp[i-2])%1000000007;
        }
        return dp[n];
    }
}
