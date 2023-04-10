package offer2;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/10 13:21
 * @description 剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
 **/
public class countBits_ {
    public int[] countBits(int n) {
        /**
         * 给一个非负整数,计算0,n之间每个数字的二进制1的个数
         *
         *
         * 其实是有规律的: 例如一个数i乘2之后的结果为2i, 那么2i在二进制位上只是向左移了一位,1的个数并没有变
         *
         * 但是2i+1的话例如:i=1, 2i+1=3, 3是: 011  1是: 001, 3在低位上多了一个1
         *
         * 所以状态转移方程为: dp[i*2]=dp[i]
         * dp[i*2+1]=dp[i]+1
         */
        if(n==0){
            return new int[]{0};
        }
        int[]res=new int[n+1];
        for (int i = 0; i < n/2; i++) {
            res[i*2]=res[i];
            if(i*2+1<=n){
                res[i*2+1]=res[i]+1;
            }
        }
        return res;

    }
}
