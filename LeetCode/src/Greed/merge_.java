package Greed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/10 14:20
 * @description 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 *56. 合并区间
 **/
public class merge_ {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        List<int[]>res=new LinkedList<>();
        int end=intervals[0][1];
        int start=intervals[0][0];
        for (int i = 1; i <intervals.length ; i++) {
            if(intervals[i][0]>end){
                res.add(new int[]{start,end});
                start=intervals[i][0];
            }
                end=Math.max(intervals[i][1],end);
        }
        res.add(new int[]{start,end});
        return res.toArray(new int[res.size()][]);
        //int[][]res1=new int[res.size()][2];

    }
}
