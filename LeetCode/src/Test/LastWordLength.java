package Test;

import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/6 14:33
 * @description TODO
 **/
public class LastWordLength {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String str = sc.nextLine();

        int res=0;

        for (int i = str.length()-1; i>=0; i--) {
            if(str.charAt(i)!=' '){
                res++;
            }else{
                break;
            }
        }
        System.out.println(res);
    }
}
