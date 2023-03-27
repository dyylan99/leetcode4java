package offer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/26 12:16
 * @description 剑指 Offer 49. 丑数
 **/
public class nthUglyNumber_ {
    public int nthUglyNumber(int n) {
        int a=0;
        int b=0;
        int c=0;
        int[]dp=new int[n];
        dp[0]=1;
        for (int i = 1; i < n; i++) {
            int n2=dp[a]*2;
            int n3=dp[b]*3;
            int n5=dp[c]*5;
            dp[i]=Math.min(Math.min(n2,n3),n5);
            if(dp[i]==n2)a++;
            if(dp[i]==n3)b++;
            if(dp[i]==n5)c++;
        }
        return dp[n-1];
    }
}
