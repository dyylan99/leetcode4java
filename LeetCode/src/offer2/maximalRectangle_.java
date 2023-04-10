package offer2;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/10 13:37
 * @description TODO
 **/
public class maximalRectangle_ {
    public int maximalRectangle(String[] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int res=0;
        //dp[i][j]为第i行第j列的连续1的个数
        int[][] dp=new int[matrix.length+1][matrix[0].length()+1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length(); j++) {
                if(matrix[i-1].charAt(j-1)=='0'){
                    continue;
                }
                //找到一个1
                dp[i][j]=dp[i][j-1]+1;
                //最大面积
                int maxArea=dp[i][j];
                int minLen=dp[i][j];
                for (int height = 2; i>=height&&matrix[i-height].charAt(j-1)!='0' ; height++) {
                    minLen=Math.min(minLen,dp[i-height+1][j]);
                    maxArea=Math.max(maxArea,height*minLen);
                }
                res=Math.max(maxArea,res);
            }
        }
        return res;
    }
}
