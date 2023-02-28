package HotOneHundred;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/27 10:41
 * @description
 *
 *
 * 10. 正则表达式匹配
 **/
public class isMatch_ {
    public boolean isMatch(String s, String p) {
        //动态规划
        //dp[i][j]代表s的前i个和p的前j个是否匹配
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <=p.length(); j++) {
                if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i][j-2];
                    if(mathches(s,p,i,j-1)){
                        dp[i][j]=dp[i][j]||dp[i-1][j];
                    }
                }else{
                    if(mathches(s,p,i,j)){
                        dp[i][j]=dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];

    }
    public boolean mathches(String s,String p,int i,int j){
        if(i==0){
            return false;
        }
        if(p.charAt(j-1)=='.'){
            return true;
        }
        return s.charAt(i-1)==p.charAt(j-1);
    }
}
