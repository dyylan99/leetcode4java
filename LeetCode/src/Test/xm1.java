package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/23 16:39
 * @description TODO
 **/
public class xm1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        int n=Integer.parseInt(split[0]);
        int r=Integer.parseInt(split[1]);
        List<List<Integer>>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            String s1 = sc.nextLine();
            String[] split1 = s1.split(",");
            int x=Integer.parseInt(split1[0]);
            int y=Integer.parseInt(split1[1]);
            int q=Integer.parseInt(split1[2]);
            list.add(Arrays.asList(x,y,q));
        }
        int x=0;
        int y=0;
        int num=0;
        for(int i=0;i<=100;i++){
            for(int j=0;j<=100;j++){
                int sum=0;
                for(List<Integer>l:list){
                    int d=(int)Math.sqrt((i-l.get(0))*(i-l.get(0))+(j-l.get(1))*(j-l.get(1)));
                    // System.out.println("d: "+d);
                    if(d<=r){
                        sum+=l.get(2)/(1+d);
                    }
                }
                if(sum>num){
                    x=i;
                    y=j;
                    num=sum;
                }
            }
        }
        System.out.println(x+","+y);
    }
}
