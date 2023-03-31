package Test;

import java.beans.beancontext.BeanContext;
import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/30 15:05
 * @description TODO
 **/
public class BossGame {
    private static int x=0;
    public static void main(String[] args) {
        BossGame bossGame = new BossGame();

        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int len = sc.nextInt();
            if(len==1){
                System.out.println(0);
               continue;
            }
            int[]nums=new int[len];
            for (int i1 = 0; i1 < len; i1++) {
                nums[i1]=sc.nextInt();
            }
            Map<Integer, List<Integer>>map=new HashMap<>();
            for (int i1 = 0; i1 < nums.length; i1++) {
                List<Integer> list;
                if(map.containsKey(nums[i1])){
                    list = map.get(nums[i1]);
                }else {
                    list = new ArrayList<>();
                }
                list.add(i1);
                map.put(nums[i1],list );
            }


            System.out.println(change(nums, map));
        }
    }

    public static int change(int[]nums,Map<Integer, List<Integer>>map){
        int res=0;
        boolean flag=false;

            for (int i = 1;i < nums.length; i++) {
                if(nums[i]<nums[i-1]){
                    List<Integer> list = map.get(nums[i-1]);
                    i=list.get(0)>0?list.get(0)-1:0;
                    for (Integer integer : list) {
                        nums[integer]=0;
                    }
                    res++;
                }
                if(i==nums.length-1){
                    flag=true;
                }
        }

        return res;
    }





}
