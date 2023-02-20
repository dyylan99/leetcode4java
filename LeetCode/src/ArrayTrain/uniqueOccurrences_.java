package ArrayTrain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/20 10:26
 * @description 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 * 1207. 独一无二的出现次数
 **/
public class uniqueOccurrences_ {
    public boolean uniqueOccurrences(int[] arr) {
       int[] count=new int[2001];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]+1000]++;
        }
        //Arrays.sort(count);
        //for (int i = 0; i < count.length-1; i++) {
        //    if(count[i]==count[i+1]&&count[i]!=0){
        //        return false;
        //    }
        //}
        //再用一层hash
        boolean[]flag=new boolean[1001];
        for (int i = 0; i < count.length; i++) {
            if(count[i]>0){
                if(!flag[count[i]]){
                    flag[count[i]]=true;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
