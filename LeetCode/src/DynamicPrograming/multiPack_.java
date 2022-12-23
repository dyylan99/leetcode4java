package DynamicPrograming;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/20 15:34
 * @description 有N种物品和一个容量为V 的背包。第i种物品最多有Mi件可用，每件耗费的空间是Ci ，价值是Wi 。
 *
 * 求解将哪些物品装入背包可使这些物品的耗费的空间 总和不超过背包容量，且价值总和最大。
 *
 * 多重背包和01背包是非常像的， 为什么和01背包像呢？
 *
 * 每件物品最多有Mi件可用，把Mi件摊开，其实就是一个01背包问题了。
 **/
public class multiPack_ {
    public void multiPack(){
        //每个物品的重量
        //int[]weight=new int[]{1,3,4};
        List<Integer>weight=new ArrayList<>(Arrays.asList(1,3,4));
        //每个物品的价值
        //int[] value=new int[]{15,20,30};
        List<Integer>value=new ArrayList<>(Arrays.asList(15,20,30));
        //每个物品的数目
        int[]nums=new int[]{2,3,2};
        int bagWeight=10;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]>1){//吧nums[i]保留到1, 其他摊开
                weight.add(weight.get(i));
                value.add(value.get(i));
                nums[i]--;
            }
        }
        int[]dp=new int[bagWeight+1];
        for (int i = 0; i < weight.size(); i++) {//遍历物品
            for (int j = bagWeight; j>=weight.get(i) ; j--) {
                dp[j]=Math.max(dp[j],dp[j-weight.get(i)]+value.get(i));
                System.out.println("i是:"+i+",dp["+j+"]是:"+dp[j]);
            }
        }
    }

    @Test
    public void test(){
        multiPack();
    }
}
