package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/12 20:33
 * @description TODO
 **/
public class test5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s="";
        s=sc.nextLine();
        String[] split = s.split(",");
        List<Integer>list=new ArrayList<>();
        for (String string : split) {
            list.add(Integer.parseInt(string));
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
        res=Math.max(res,pre-left+1);
        System.out.println(res);
    }
}
