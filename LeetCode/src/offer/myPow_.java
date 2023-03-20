package offer;

import org.junit.Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/17 13:12
 * @description TODO
 **/
public class myPow_ {
    public double myPow(double x, int n) {
        //快速幂法
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1 / x;
        double half = myPow(x, n / 2);
        double mod = myPow(x, n % 2);
        return half * half * mod;
    }
    @Test
    public void test(){
        System.out.println(myPow(2.0,10));
    }

}
