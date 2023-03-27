package offer;

import org.junit.Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/24 14:47
 * @description TODO
 **/
public class translateNum_ {
    public int translateNum(int num) {
        if (num<10){
            return 1;
        }
        char[] chars = String.valueOf(num).toCharArray();
        int[]dp=new int[chars.length];
        //dp[i]为结尾为char[i]的数包含多少种转换方法
        //则dp[0]就为1
        dp[0]=1;
        //char[1]和char[2]的组合必须在10-25之间
        dp[1]=chars[0]-'0'==1||(chars[0]-'0'==2&&chars[1]-'0'<6)?2:1;
        for (int i = 2; i <chars.length ; i++) {
            int tem=chars[i-1]-'0';
            dp[i]=tem==1||(tem==2&chars[i]-'0'<6)?dp[i-1]+dp[i-2]:dp[i-1];
        }
        return dp[chars.length-1];
    }

}
