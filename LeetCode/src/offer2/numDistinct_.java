package offer2;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/20 15:16
 * @description 剑指 Offer II 097. 子序列的数目
 **/
public class numDistinct_ {
    public int numDistinct1(String s, String t) {
        if (s.length()<t.length()){
            return 0;
        }
        int ns=s.length();
        int nt=t.length();

        int[][]dp=new int[ns+1][nt+1];

        for (int i = 0; i <=ns; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i <=ns ; i++) {
            for (int j = 1; j <=nt ; j++) {
                if (s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[ns][nt];
    }
    public int numDistinct2(String s, String t) {
        if (s.length()<t.length()){
            return 0;
        }
        int ns=s.length();
        int nt=t.length();
        int[]dp=new int[nt+1];
        dp[0]=1;
        for (int i = 1; i <=ns ; i++) {
            for (int j = nt; j>0 ; j--) {
                if (s.charAt(i-1)==t.charAt(j-1)){
                    dp[j]+=dp[j-1];
                }
            }
        }
        return dp[nt];
    }
}
