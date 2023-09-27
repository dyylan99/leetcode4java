package cn.dylan.dp;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/20 16:06
 * @description TODO
 **/
public class uniquePaths_ {
    public int uniquePaths(int m, int n) {
        int[][]dp=new int[m][n];
        //dp[i][j]是从0,0开始, 到i,j 有多少种走法
        //dp[i][j]=dp[i-1][j]+dp[i][j-1]

        for (int i = 0; i < m; i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i <m; i++) {
            for (int j = 1; j <n ; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
