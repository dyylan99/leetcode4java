package cn.dylan.HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/8/26 16:23
 * @description 202. 快乐数
 **/
public class isHappy_ {
    public boolean isHappy(int n){

        Set<Integer>set=new HashSet<>();
        while (true){
            int sum=getSum(n);
            if (sum==1){
                return true;
            }
            //出现了循环
            if (set.contains(sum)){
                return false;
            }
            set.add(sum);
            n=sum;

        }
    }
    /**
     * 取整数各个位置上的平方和
     */
    public int getSum(int num){
        int sum=0;
        while (num!=0){
            sum+=(num%10)*(num%10);
            num/=10;
        }
        return sum;
    }
}
