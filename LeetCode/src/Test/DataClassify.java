package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/8 14:41
 * @description TODO
 **/
public class DataClassify {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n = sc.nextInt();
        int[] INums=new int[n];
        for (int i = 0; i < n; i++) {
            INums[i]=sc.nextInt();
        }
        int k = sc.nextInt();
        //int[] RNums=new int[k];
        TreeSet<Integer>set=new TreeSet<>();
        for (int i = 0; i < k; i++) {
            set.add(sc.nextInt());
        }

        List<Integer>list=new ArrayList<>();
        for (Integer integer : set) {
            analysis(integer,INums,list);
        }
        System.out.print(list.size()+" ");
        for (int i = 0; i < list.size(); i++) {
            if(i==list.size()-1){
                System.out.print(list.get(i));
            }else {
                System.out.println(list.get(i)+" ");
            }

        }
    }

    public static void analysis(int num,int[]INums,List<Integer>list){
        List<Integer>res=new ArrayList<>();
        for (int i = 0; i < INums.length; i++) {
            if(String.valueOf(INums[i]).contains(String.valueOf(num))){
                res.add(i);
            }
        }
        if(res.size()==0){
            return;
        }
        list.add(num);
        list.add(res.size());
        for (Integer re : res) {
            list.add(re);
            list.add(INums[re]);
        }
    }
}
