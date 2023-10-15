package cn.dylan.dp;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/18 15:52
 * @description 1143. 最长公共子序列
 **/
public class longestCommonSubsequence_ {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        //dp[i][j]代表长度为i的text1串和长度为j的text2串包含最后一个字符的最长公共子序列
        //递推公式: 当s1[i]==s[j]的时候, dp[i][j]=dp[i-1][j-1]+1;
        //否则: p[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
        int[][]dp=new int[m+1][n+1];

        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n; j++) {
                if (text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
