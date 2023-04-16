package offer2;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/16 16:41
 * @description 剑指 Offer II 094. 最少回文分割
 **/
public class minCut_ {
    public int minCut(String s) {
        if (s.length()==1){
            return 0;
        }
        //dp[i][j]表示以i开头,以j结尾的字符串是不是回文串
        boolean[][]dp=new boolean[s.length()][s.length()];
        for (int i = s.length()-1; i>=0 ; i--) {
            dp[i][i]=true;
            for (int j = i+1; j <s.length() ; j++) {
                boolean b = s.charAt(i) == s.charAt(j);
                dp[i][j]=j-i<=2? b : b &&dp[i+1][j-1];
            }
        }
        //countDp[i]表示以i-1结尾的字符串最少需要分割多少次
        int []countDp=new int[s.length()+1];
        countDp[0]=-1;
        for (int i = 1; i <=s.length() ; i++) {
            countDp[i]=Integer.MAX_VALUE;
            for (int j = 1; j <=i ; j++) {
                if (dp[j-1][i-1]){
                    countDp[i]=Math.min(countDp[i],countDp[j-1]+1);
                }
            }
        }
        return countDp[s.length()];
    }

}
