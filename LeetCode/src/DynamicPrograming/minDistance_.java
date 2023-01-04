package DynamicPrograming;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/1/4 14:52
 * @description 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 *
 * 每步 可以删除任意一个字符串中的一个字符。
 *
 * 583. 两个字符串的删除操作
 **/
public class minDistance_ {
    public int minDistance(String word1, String word2) {
        /**
         * dp[i][j]：以i-1为结尾的字符串word1，和以j-1位结尾的字符串word2，想要达到相等，所需要删除元素的最少次数。
         *
         * 确定递推公式
         * 1.当word1[i - 1] 与 word2[j - 1]相同的时候
         * 2.当word1[i - 1] 与 word2[j - 1]不相同的时候
         *
         *
         * 1.dp[i][j]=dp[i-1][j-1]
         *
         * 2.情况一:  删除word1[i-1], 最少的操作次数为dp[i-1][j]+1
         * 情况二: 删除word2[j-1],最少操作次数为dp[i][j-1]+1;
         * 情况三: 同时删除word1[i-1],word2[j-1],最少的操作次数为: dp[i-1][j-1]+2
         * 三种情况取最小值
         */
        int[][]dp=new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i <= word1.length() ; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i <=word2.length() ; i++) {
            dp[0][i]=i;
        }
        for (int i = 1; i <=word1.length() ; i++) {
            for (int j = 1; j <=word2.length() ; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(dp[i-1][j]+1,Math.min(dp[i][j-1]+1,dp[i-1][j-1]+2));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
