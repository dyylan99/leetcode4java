package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/12 19:45
 * @description "daniel","daniel","daniel","luis","luis","luis","luis"
 * "10:00","10:40","11:00","09:00","11:00","13:00","15:00"
 **/
public class test3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<String>list=new ArrayList<>();

        while (sc.hasNext()){
            list.add(sc.next());
        }
        String[]names=new String[list.size()/2];
        for (int i = 0; i < names.length; i++) {
            names[i]=list.get(i);
        }
        int []min=new int[list.size()/2];
        int index=0;
        for (int i = list.size()/2; i <list.size() ; i++) {
            String hour=list.get(i).substring(0,2);
            String mins=list.get(i).substring(3);
            int time=Integer.parseInt(hour)*60+Integer.parseInt(mins);
            min[index++]=time;
        }
        PriorityQueue<String>pq=new PriorityQueue<>();
        int left=0;
        int right=3;
        String cur="";
        while (right<=names.length){
            if (names[left].equals(names[right]) && !cur.equals(names[left])){
                if (min[right]-min[left]>60){
                    pq.add(names[left]);
                    cur=names[left];
                }
            }
            left++;
            right++;
        }
        List<String> res = new ArrayList<>(pq);
        System.out.println(res);
    }
}
