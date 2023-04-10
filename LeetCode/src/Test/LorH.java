package Test;

import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/4 19:15
 * @description TODO
 **/
public class LorH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String s = sc.next();

        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            liarOrHonester(s,x,y);
        }
    }

    public static void liarOrHonester(String s,int x,int y){
        if(s.charAt(x-1)=='H'){
            if(s.charAt(y-1)=='L'){
                System.out.println("liar");
            }else{
                System.out.println("honester");
            }
        }else{
            if(s.charAt(y-1)=='L'){
                System.out.println("honester");
            }else{
                System.out.println("liar");
            }
        }
    }
}
