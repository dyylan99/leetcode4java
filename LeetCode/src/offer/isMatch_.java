package offer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/17 13:55
 * @description TODO
 **/
public class isMatch_ {
    public boolean isMatch(String s, String p) {
        /**
         *  //动态规划
         *         //dp[i][j]代表s的前i个和p的前j个是否匹配
         */
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if(p.charAt(j-1)=='*'){
                    //如果在j位置上的p是'*'的话,那么dp[i][j]可以直接和dp[i][j-2]划上等号
                    dp[i][j]=dp[i][j-2];
                    if(matches(s,p,i,j-1)){
                        dp[i][j]=dp[i][j]||dp[i-1][j];
                    }
                }else{
                    if(matches(s,p,i,j)){
                        dp[i][j]=dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    boolean matches(String s,String p,int i,int j){
        if(i==0){
            return false;
        }
        if(p.charAt(j-1)=='.'){
            //'.'可以代表任何一个字符
            return true;
        }
        return s.charAt(i)==p.charAt(j);
    }
}
