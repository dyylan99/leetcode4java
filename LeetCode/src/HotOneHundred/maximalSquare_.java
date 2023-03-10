package HotOneHundred;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/9 13:13
 * @description TODO
 **/
public class maximalSquare_ {
    public int maximalSquare(char[][] matrix) {
            int row=matrix.length;
            int col=matrix[0].length;
            int res=0;
            int dp[][]=new int[row+1][col+1];
            for (int i = 1; i <= row; i++) {
                for (int i1 = 1; i1 <= col; i1++) {
                    if(matrix[i-1][i1-1]=='0'){
                        continue;
                    }
                    //找到一个1
                    dp[i][i1]=dp[i][i1-1]+1;
                    int maxArea=1;
                    int minLength=dp[i][i1];
                    for (int height = 2; height<=i&&matrix[i-height][i1-1]!='0' ; height++) {
                        minLength=Math.min(dp[i-height+1][i1],minLength);
                        int minLen=Math.min(minLength,height);
                        maxArea=Math.max(maxArea,minLen*minLen);
                    }
                    res=Math.max(res,maxArea);
                }
            }
            return res;
    }
}
