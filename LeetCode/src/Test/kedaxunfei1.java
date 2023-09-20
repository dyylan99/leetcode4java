package Test;

import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/15 19:45
 * @description TODO
 **/
public class kedaxunfei1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n=in.nextInt();
        System.out.println(getCharAtIndex(n));
    }

    private static char getCharAtIndex(int n){
       StringBuilder sb=new StringBuilder();
       int num=0;
       while (sb.length()<n){
           sb.append(num);
           num+=2;
       }
        return sb.charAt(n-1);
    }
}
