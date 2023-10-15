package cn.dylan.dp;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/10/4 19:46
 * @description 72. 编辑距离
 **/
public class minDistance_ {
    public int minDistance(String word1, String word2) {
        //dp[i][j]代表以下标i-1结尾的word1和以下标j-1结尾的word2的最短编辑距离(包含结尾元素)
        int[][]dp=new int[word1.length()+1][word2.length()+1];
        //初始化
        for (int i = 0; i <=word1.length(); i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i <=word2.length(); i++) {
            dp[0][i]=i;
        }
        for (int i = 1; i <=word1.length(); i++) {
            for (int j = 1; j <=word2.length(); j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    //结尾元素相等时, 不需要额外编辑
                    dp[i][j]=dp[i-1][j-1];
                }else{ //不相等时
                    //                删除i-1               删除j-1       替换当前元素为相等元素
                    dp[i][j]=Math.min(dp[i-1][j]+1,Math.min(dp[i][j-1]+1,dp[i-1][j-1]+1));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
