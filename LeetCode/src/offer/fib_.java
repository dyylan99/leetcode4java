package offer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/16 13:44
 * @description 剑指 Offer 10- I. 斐波那契数列
 **/
public class fib_ {
    public int fib(int n) {
        if(n==0){
            return n;
        }
        int sum=1;
        int f=0;int b=1;
        for(int i=2;i<n;i++){
            f=b;
            b=sum;
            sum=(f+b)%1000000007;
        }
        return sum;
    }
}
