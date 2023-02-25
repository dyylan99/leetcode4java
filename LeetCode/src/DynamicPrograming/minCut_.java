package DynamicPrograming;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/25 10:20
 * @description 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 *
 * 返回符合要求的 最少分割次数 。
 *
 * 132. 分割回文串 II
 **/
public class minCut_ {
    public int minCut(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        //dp[i]范围是[0,i]的回文子串,最少分割次数是dp[i]
        int[]dp=new int[s.length()];
        boolean[][]isPalindromic=new boolean[s.length()][s.length()];
        for (int i = s.length()-1; i >=0 ; i--) {
            for (int j = i; j <s.length() ; j++) {
                if(s.charAt(i)==s.charAt(j)&&(j-i<=1||isPalindromic[i+1][j-1])){
                    isPalindromic[i][j]=true;
                }else{
                    isPalindromic[i][j]=false;
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            dp[i]=i;
        }
        for (int i = 1; i <s.length() ; i++) {
            if(isPalindromic[0][i]){
                dp[i]=0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if(isPalindromic[j+1][i]){
                    dp[i]=Math.min(dp[i],dp[j]+1);
                }
            }
        }
        return dp[s.length()-1];
    }
}
