package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/7/14 17:14
 * @description 904. 水果成篮
 *
 *
 **/
public class totalFruit {
    public int totalFruit(int[] f) {
        int left=0;
        int right=0;
        int max=0;
        int count=0; //记录目前摘取到的水果种类
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int j : f) {
            map.put(j, 0);
        }
       while (right<f.length){
           //若当前还未采摘过, 那么记录的采摘种类就加一
           if (map.get(f[right])==0){
               count++;
           }
           //执行采摘过程
           map.put(f[right],map.get(f[right])+1);
           //处理采摘种类超出的情况(控制在两个以内)
           while (count>2){
               if (map.get(f[left])==1){
                   count--;
               }
               map.put(f[left],map.get(f[left])-1);
               left++;
           }
           //实时更新采摘的数目
           max=Math.max(max,right-left+1);
           //继续向后采摘
           right++;

       }
        return max;
    }
}
