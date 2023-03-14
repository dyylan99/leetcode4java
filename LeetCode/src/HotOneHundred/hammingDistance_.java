package HotOneHundred;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/13 14:17
 * @description 461. 汉明距离
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。x
 **/
public class hammingDistance_ {
    public int hammingDistance(int x, int y) {
        //return Integer.bitCount(x^y);
        x=x^y;
        y=0;//用y来记录个数
        while(x!=0){
            if(x%2==1) y++;
            x/=2;
        }
        return y;
    }
}
