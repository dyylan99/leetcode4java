package Test;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/12 19:25
 * @description TODO
 **/
public class MostFood {
    public static int res=Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n = sc.nextInt();
        boolean[]visited=new boolean[n];
        List<List<Integer>>list=new ArrayList<>(10000);
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        Map<Integer,List<Integer>>map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            int index=sc.nextInt();
            int parent=sc.nextInt();
            int value=sc.nextInt();
            List<Integer>list1;
            if(!map.containsKey(parent)){
                list1=new ArrayList<>();
            }else{
                list1=map.get(parent);
            }
            list1.add(index);
            map.put(parent,list1);
            list.set(index,Arrays.asList(parent,value));
            res=Math.max(res,value);
        }
        //起点
        Integer start = map.get(-1).get(0);
        traverse(map,list,visited,start,0);
        for (Integer integer : map.keySet()) {
            if(integer!=-1){
                traverse(map,list,visited,integer,0);
            }
        }
        System.out.println(res);
    }
    public static void traverse(Map<Integer,List<Integer>>map,List<List<Integer>>list,boolean[]visited,int start,int sum){
        List<Integer> list1 = map.get(start);
        sum+=list.get(start).get(1);
        res=Math.max(res,sum);
        if(list1==null){
            return;
        }
        visited[start]=true;


        for (Integer integer : list1) {
            if (!visited[integer]){
                traverse(map,list,visited,integer,sum);
            }else{
                continue;
            }
        }
        visited[start]=false;
    }

}


