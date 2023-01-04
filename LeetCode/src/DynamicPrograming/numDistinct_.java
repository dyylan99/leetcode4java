package DynamicPrograming;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/1/4 14:36
 * @description 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 *
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 题目数据保证答案符合 32 位带符号整数范围。
 *
 *
 * 115. 不同的子序列
 **/
public class numDistinct_ {
    public int numDistinct(String s, String t) {
        /**
         * dp[i][j]：以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为dp[i][j]。
         * 当s[i-1]与t[j-1]相等时,那么dp[i][j]可以为dp[i-1][j-1]+dp[i-1][j]
         * 当其不相等时, dp[i][j]为dp[i-1][j]
         */
        int[][]dp=new int[s.length()+1][t.length()+1];
        //dp[i][0]的初始化
        for (int i = 0; i <=s.length() ; i++) {
            dp[i][0]=1;
        }
        //dp[0][i]的初始化
        for (int i = 1; i <=t.length(); i++) {
            dp[0][i]=0;
        }
        for (int i = 1; i <=s.length() ; i++) {
            for (int j = 1; j <=t.length() ; j++) {
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
