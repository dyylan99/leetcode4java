package DynamicPrograming;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/1/3 15:35
 * @description 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 *
 * 1143. 最长公共子序列
 **/
public class longestCommonSubsequence_ {
    public int longestCommonSubsequence(String text1, String text2) {
        //dp[i][j]的定义:
        //       长度为[0][i-1]的text1和长度为[0][j-1]的text2的最长公共子序列的长度
        //因此: 如果chars1[i-1]==chars[j-1]的话,那么dp[i][j]=dp[i-1][j-1]+1,如果不相等,那就看text1[0,i-2]和text2[0,j=1]的最长子序列和
        // text1[0,i-1]和text2[0,j-2]的最长子序列,取最长的
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[][]dp=new int[chars1.length+1][chars2.length+1];
        for (int i = 1; i <=chars1.length ; i++) {
            for (int j = 1; j <=chars2.length ; j++) {
                if(chars1[i-1]==chars2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[chars1.length][chars2.length];
    }
}
