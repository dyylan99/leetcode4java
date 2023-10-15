package cn.dylan.SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/19 14:57
 * @description 56. 合并区间
 **/
public class merge_ {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        List<int[]>ans=new ArrayList<>();
        ans.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int s=intervals[i][0],e=intervals[i][1];
            if (ans.get(ans.size()-1)[1]<s){
                ans.add(intervals[i]);
            }else{
                ans.get(ans.size()-1)[1]=Math.max(ans.get(ans.size()-1)[1],e);
            }
        }
        return ans.toArray(new int[ans.size()][]);


    }
}
