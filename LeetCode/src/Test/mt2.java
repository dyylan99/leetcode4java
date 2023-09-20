package Test;

import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/16 19:05
 * @description TODO
 **/
public class mt2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int x = in.nextInt();
        int y = in.nextInt();
        int dis=x*x+y*y;
        int d=1;
        while (dis>d*d){
            d++;
        }
        System.out.println(11-d);
    }
}
