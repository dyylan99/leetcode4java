package cn.dylan.dp;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/17 13:48
 * @description 474. 一和零
 **/
public class findMaxForm_ {
    public int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j]：最多有i个0和j个1的strs的最大子集的大小为dp[i][j]
        int[][]dp=new int[m+1][n+1];
        for (String str : strs) {
            int one=0;
            int zero=0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i)=='0'){
                    zero++;
                }else {
                    one++;
                }
            }
            for (int j = m; j>=zero ; j--) {
                for (int k = n; k>=one ; k--) {
                    dp[j][k]=Math.max(dp[j][k],dp[j-zero][k-one]+1);
                }
            }
        }
        return dp[m][n];

    }
}
