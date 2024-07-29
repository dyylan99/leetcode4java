package Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/10/11 13:25
 * @description TODO
 **/
public class lixaing1 {
    public int Fibonacci (int n) {
        int[]dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for (int i = 2; i <=n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
