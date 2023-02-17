package DynamicPrograming;


/**
 * @author Dylan
 * @version 1.0
 * @date 2023/1/4 14:17
 * @description 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 *
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 392. 判断子序列
 **/


public class isSubsequence_ {
    int num;
    public boolean isSubsequence(String s, String t) {//
        /**
         * dp[i][j] 表示以下标i-1为结尾的字符串s，和以下标j-1为结尾的字符串t，相同子序列的长度为dp[i][j]。
         */
        int[][]dp=new int[s.length()+1][t.length()+1];
        for (int i = 1; i <=s.length() ; i++) {
            for (int j = 1; j <=t.length() ; j++) {
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        if(dp[s.length()][t.length()]==s.length()){
            return true;
        }
        return false;
    }
    /**
     * 双指针法
     */
    public boolean isSubsequence1(String s, String t){
        if(s.length()==0){
            return true;
        }
        char Index1=s.charAt(0);
        int sIndex=0;
        for (int i = 0; i < t.length(); i++) {
            char Index2=t.charAt(i);
            if(Index2==Index1){
                sIndex++;
                if(sIndex==s.length()){
                    return true;
                }
                Index1=s.charAt(sIndex);
            }
        }
        return false;
    }
}
