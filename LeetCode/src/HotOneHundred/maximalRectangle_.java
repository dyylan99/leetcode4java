package HotOneHundred;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/3 10:50
 * @description 85. 最大矩形
 **/
public class maximalRectangle_ {
    public int maximalRectangle(char[][] matrix) {
        //动态规划:
        /**
         * dp[i][j]为第i行,第1列第j列最长连续1的长度
         */
        int m=matrix.length;
        int n=matrix[0].length;
        int res=0;
        int dp[][]=new int[m+1][n+1];
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(matrix[i-1][j-1]=='0'){
                    continue;
                }
                //找到一个1
                dp[i][j]=dp[i][j-1]+1;
                int maxArea=dp[i][j];
                int minLength=dp[i][j];
                for (int height = 2; i>=height&&matrix[i-height][j-1]!='0'; height++) {
                    minLength=Math.min(minLength,dp[i-height+1][j]);


                    maxArea=Math.max(maxArea,height*minLength);
                }
                res=Math.max(maxArea,res);
            }
        }
        return res;
    }
}
