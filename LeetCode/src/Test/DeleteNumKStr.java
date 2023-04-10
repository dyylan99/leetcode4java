package Test;

import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/9 18:11
 * @description TODO
 **/
public class DeleteNumKStr {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int k = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        StringBuilder sb=new StringBuilder();
        int index=1;
        while (index<str.length()&&(index+k)<=str.length()){
            sb.append(str, index, index+k);
            index=index+k+1;
        }
        if(index<str.length()){
            sb.append(str,index,str.length());
        }
        System.out.println(sb);
    }
}
