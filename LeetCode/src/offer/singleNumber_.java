package offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/28 14:37
 * @description TODO
 **/
public class singleNumber_ {
    public int singleNumber(int[] nums) {
        /**
         * 书上解法： 如果一个数字出现3次，它的二进制每一位也出现的3次。
         * 如果把所有的出现三次的数字的二进制表示的每一位都分别加起来，那么每一位都能被3整除。
         * 我们把数组中所有的数字的二进制表示的每一位都加起来。如果某一位能被3整除，那么这一位对只出现一次的那个数的这一肯定为0。
         * 如果某一位不能被3整除，那么只出现一次的那个数字的该位置一定为1.
         */

        int[]k=new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                k[j]+=(nums[i]>>j&1)==1?1:0;
            }
        }
        int res=0;
        for (int i = 31; i >=0; i--) {
            res=res<<1;
            if(k[i]%3==1){
                res=(res|1);
            }
        }
        return res;
    }
}
