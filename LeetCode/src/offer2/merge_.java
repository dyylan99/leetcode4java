package offer2;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/5/1 14:32
 * @description TODO
 **/
public class merge_ {

    public int[][] merge(int[][] intervals) {
        if (intervals==null||intervals.length<2){
            return intervals;
        }
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });

        LinkedList<int[]>list=new LinkedList<>();
        int start=intervals[0][0];
        int end=intervals[0][1];
        for (int i = 1; i <intervals.length ; i++) {
            if (intervals[i][0]>end){
                list.add(new int[]{start,end});
                start=intervals[i][0];
            }
            end=Math.max(end,intervals[i][1]);
        }
        list.add(new int[]{start,end});
        return list.toArray(new int[list.size()][]);

    }
}
