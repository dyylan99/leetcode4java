package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/12 20:10
 * @description TODO
 **/
public class test4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<Integer>list=new ArrayList<>();
        while (sc.hasNextInt()){
            list.add(sc.nextInt());
        }
        int left=0;
        int right=1;
        int pre=0;
        int res=1;
        while (right<list.size()){
            if (list.get(right)<list.get(pre)){
                pre=right;
            }else{
                res=Math.max(res,pre-left+1);
                left=right;
                pre=left;
            }
            right++;
        }
        System.out.println(res);
    }

}
