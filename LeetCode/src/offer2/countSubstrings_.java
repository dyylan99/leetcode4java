package offer2;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/10 13:29
 * @description 剑指 Offer II 020. 回文子字符串的个数
 **/
public class countSubstrings_ {
    public int countSubstrings(String s) {
        boolean[][]dp=new boolean[s.length()][s.length()];
        //dp[i][j]是以i开始,j结尾的字符串是否是回文字符串
        int res=0;
        for (int i = s.length()-1; i>=0 ; i--) {
            for (int j = i; j <s.length() ; j++) {
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<=1){
                        //相差一位,或者是同一位,默认为是回文字符串
                        res++;
                        dp[i][j]=true;
                    }else if(dp[i+1][j-1]){
                        //相差两位,那么需要比较左右指针回退一格是否是回文字符串,如果是就+1
                        res++;
                        dp[i][j]=true;
                    }
                }
            }
        }
        return res;
    }
}
