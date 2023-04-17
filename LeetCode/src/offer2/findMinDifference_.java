package offer2;

import org.junit.Test;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/17 19:36
 * @description TODO
 **/
public class findMinDifference_ {
    public int findMinDifference(List<String> timePoints) {

        int res=Integer.MAX_VALUE;
        PriorityQueue<String>pq=new PriorityQueue<>();
        for (String timePoint : timePoints) {
            pq.add(timePoint);
        }
        String pre=pq.poll();
        String first=pre;
        String cur="";
        while (!pq.isEmpty()){
            cur= pq.poll();
            res=Math.min(getDiff(pre,cur),res);
            pre=cur;
        }
        //最大的和最小的需要额外处理
        String[] firsts = first.split(":");
        String[] curs = cur.split(":");
        int hourDiff=Integer.parseInt(firsts[0])+24-Integer.parseInt(curs[0]);
        int minDiff=Integer.parseInt(firsts[1])-Integer.parseInt(curs[1]);
        return Math.min(res,hourDiff*60+minDiff);
    }

    public int findMinDifference1(List<String> timePoints){
        if (timePoints.size() > 24 * 60) {
            return 0;
        }
        List<Integer> mins = new ArrayList<>();
        for (String t : timePoints) {
            String[] time = t.split(":");
            mins.add(Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]));
        }
        Collections.sort(mins);
        mins.add(mins.get(0) + 24 * 60);
        int res = 24 * 60;
        for (int i = 1; i < mins.size(); ++i) {
            res = Math.min(res, mins.get(i) - mins.get(i - 1));
        }
        return res;
    }

    private int getDiff(String pre,String cur){
        String[] pres = pre.split(":");
        String[] curs = cur.split(":");

        int hourDiff=Integer.parseInt(curs[0])-Integer.parseInt(pres[0]);
        int minDiff=Integer.parseInt(curs[1])-Integer.parseInt(pres[1]);
        return hourDiff*60+minDiff;
    }


}
