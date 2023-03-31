package Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/28 19:21
 * @description TODO
 **/
public class StringBaidu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        String[]strings=new String[n];

        for (int i = 0; i < n; i++) {
            strings[i]=sc.next();
        }
        for (String string : strings) {
            int[]tmp=new int[5];
            if(string.length()!=5){
                System.out.println("No");
                continue;
            }
            for (int i = 0; i < string.length(); i++) {
                char c=string.charAt(i);
                if(c=='B'){
                    tmp[0]++;
                }else if(c=='a'){
                    tmp[1]++;
                }else if(c=='i'){
                    tmp[2]++;
                }else if(c=='d'){
                    tmp[3]++;
                }else if(c=='u'){
                    tmp[4]++;
                }
            }
            for (int i = 0; i < tmp.length; i++) {
                if(tmp[i]!=1){
                    System.out.println("No");
                    break;
                }
                if(i==tmp.length-1){
                    System.out.println("Yes");
                }
            }

        }


    }
}
