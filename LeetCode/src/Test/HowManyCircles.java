package Test;

import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/29 19:03
 * @description TODO
 **/
public class HowManyCircles {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String num = sc.next();
        System.out.println(circles(num));
    }

    public static int circles(String num){
        char[] chars = num.toCharArray();
        int res=0;
        for (char aChar : chars) {
            if(aChar=='0'||aChar=='6'||aChar=='9'){
                res++;
            }else if(aChar=='8'){
                res=res+2;
            }
        }
        return res;
    }


}
