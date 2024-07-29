package Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/23 14:13
 * @description TODO
 **/
public class wy2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        String[]strings=new String[n];
        for (int i = 0; i < n; i++) {
            strings[i]=sc.next();
        }
        Arrays.sort(strings, Comparator.comparingInt(String::length));
        for (int i = 0; i < strings.length; i++) {
            char[] charArray = strings[i].toCharArray();
            Arrays.sort(charArray);
            strings[i]=new String(charArray);
        }
        Arrays.sort(strings,(a,b)->{
            if (a.length()!=b.length()){
                return a.length()-b.length();
            }else{
                for (int i = 0; i < a.length(); i++) {
                    if (a.charAt(i)!=b.charAt(i)){
                        return a.charAt(i)-b.charAt(i);
                    }
                }
                return 0;
            }
        });
        for (String string : strings) {
            System.out.println(string);
        }
        int left=0,right=left+1;
        int res=0;
        while (right<strings.length){
            if (strings[left].equals(strings[right])){
                res++;
                right++;
            }else{
                left++;
                right=left+1;
            }
        }
        System.out.println(res);
    }
}
