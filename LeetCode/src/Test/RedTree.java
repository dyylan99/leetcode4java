package Test;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/4 19:24
 * @description TODO
 **/
public class RedTree {
    private static int res=0;
    private static Map<Integer, List<Integer>>map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String tree = sc.next();
        map=new HashMap<>();
        for (int i = 0; i < n-1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            List<Integer> list;
            if(map.containsKey(x)){
                list = map.get(x);
            }else{
                list = new LinkedList<>();
            }
            list.add(y);
            map.put(x,list);
        }
        traverse(1,tree);
        System.out.println(res);
    }

    public static boolean traverse(int start,String tree){
        if(!map.containsKey(start)){
            if(tree.charAt(start-1)=='R'){
                res++;
                return true;
            }else{
                return false;
            }
        }
        //所有叶子结点
        List<Integer> list = map.get(start);
        boolean flag=true;
        for (Integer integer : list) {
            flag=flag&traverse(integer,tree);
        }
        if(flag){
            if(tree.charAt(start-1)=='R'){
                res++;
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
}
