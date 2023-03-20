package offer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/17 13:02
 * @description 剑指 Offer 15. 二进制中1的个数
 **/
public class hammingWeight_ {
    public int hammingWeight(int n) {
        int sum = 0;
        while( n != 0){
            n &= n -1;
            sum++;
        }
        return sum;
    }
}
