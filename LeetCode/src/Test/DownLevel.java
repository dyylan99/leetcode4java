package Test;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/12 19:03
 * @description TODO
 **/
public class DownLevel {
    public static Set<Integer>set=new HashSet<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<Integer>list=new ArrayList<>();

        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int sum=0;
        for (String s2 : s1) {
            int num=Integer.parseInt(s2);
            sum+=num;
            list.add(num);
        }
        int cnt = sc.nextInt();
        if(cnt>=sum){
            System.out.println(-1);
            return;
        }
        int limit=cnt/list.size();
        if (limit<1){
            System.out.println(0);
            return;
        }
        int sum1=0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)<=limit){
                sum1+=list.get(i);
                set.add(i);
            }
        }
        int tmp=cnt-sum1;
        int limit2=tmp/(list.size()-set.size());
        limit2=getLimit(list,cnt,limit2,sum1);
        System.out.println(limit2);
    }
    public static int getLimit(List<Integer>list,int cnt,int limit,int sum){
        for (int i = 0; i < list.size(); i++) {
            if(!set.contains(i)){
                if(list.get(i)<=limit){
                    sum+=list.get(i);
                    set.add(i);
                }
            }
        }
        int tmp=cnt-sum;
        int limit2=tmp/(list.size()-set.size());
        if (limit2>limit){
            getLimit(list,cnt,limit2,sum);
        }
        return limit2;
    }
}
