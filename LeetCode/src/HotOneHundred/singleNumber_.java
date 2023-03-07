package HotOneHundred;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/7 9:48
 * @description 136. 只出现一次的数字
 *
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间
 **/
public class singleNumber_ {
    //使用位运算
    public int singleNumber(int[] nums) {
        int res=0;
        for (int num : nums) {
            res^=num;
        }
        return res;
    }

    @Test
    public void test(){
        singleNumber(new int[]{2,2,1});
    }
}
