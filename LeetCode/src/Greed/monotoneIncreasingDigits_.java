package Greed;

import org.junit.Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/12 12:48
 * @description 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 *
 * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
 *
 * 738. 单调递增的数字
 **/
public class monotoneIncreasingDigits_ {
    public int monotoneIncreasingDigits(int n) {
        String num=String.valueOf(n);
        char[] chars=num.toCharArray();
        int flag=num.length();
        for (int i = num.length()-1; i>0 ; i--) {
            if(chars[i-1]>chars[i]){
                chars[i-1]--;
                flag=i;
            }
        }
        for (int i = flag; i < chars.length; i++) {
            chars[i]='9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }

    //超时
    public boolean isIncreasing(int n){
        int tem=99;
        while (n>0){
            if(tem<n%10){
                return false;
            }
            tem=n%10;
            n/=10;
        }
        return true;
    }
    @Test
    public void test6(){
        //System.out.println(isIncreasing(614031667));
        System.out.println(monotoneIncreasingDigits(1032));
    }
}
