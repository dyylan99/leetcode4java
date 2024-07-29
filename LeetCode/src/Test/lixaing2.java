package Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/10/11 13:27
 * @description TODO
 **/
public class lixaing2 {
    public String longestPalindrome (String s) {
        int left=0,right=0,res=1;
        int len=s.length();
        boolean[][]dp=new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i]=true;
        }
        for (int i = len-1; i>=0 ; i--) {
            for (int j = i; j <len; j++) {
                if (s.charAt(i)==s.charAt(j)){
                    if (j-i<=1 || dp[i+1][j-1]){
                        dp[i][j]=true;
                    }
                }
                if (dp[i][j] && j-i+1>res){
                    res=j-i+1;
                    left=i;
                    right=j+1;
                }
            }
        }
        return s.substring(left,right);
    }
}
