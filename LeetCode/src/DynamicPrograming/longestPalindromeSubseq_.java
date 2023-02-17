package DynamicPrograming;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/17 12:17
 * @description 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 *
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 *
 *
 * 516. 最长回文子序列
 **/
public class longestPalindromeSubseq_ {


    public int longestPalindromeSubseq(String s) {
        //dp[i][j]的定义: 字符串s在[i,j]的范围内最长的回文子序列的长度为dp[i][j]
        int[][]dp=new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i]=1;//j,i相同时, 最长回文子序列的长度为1
        }
        /**
         * 当s[i]==s[j]时,那么就是将s[i]和s[j]同时加入到子序列中,则dp[i][j]=dp[i+1][j-1]+2
         *
         * 若s[i]!=s[j]时,那么就是尝试抛弃其中一个重新计算dp[i][j]=math.max(dp[i+1][j],dp[i][j-1])
         */
        for (int i = s.length()-1; i>=0 ; i--) {
            for (int j = i+1; j <s.length() ; j++) {
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else {
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }

}
