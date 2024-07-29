package Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/22 19:21
 * @description TODO
 **/
public class tongdun1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        String[]strings=new String[n];
        for (int i = 0; i < n; i++) {
            strings[i]=sc.next();
        }
        int count=0;
        Set<String>set=new HashSet<>();
        for (String string : strings) {
            char[] charArray = string.toCharArray();
            Arrays.sort(charArray);
            String s=new String(charArray);
            if (!set.contains(s)){
                set.add(s);
                count++;
            }
        }
        System.out.println(count);
    }
}
