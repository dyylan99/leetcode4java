package Test;

import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/6 14:08
 * @description TODO
 **/
public class bottle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            if(n==0){
                break;
            }
            System.out.println(getNums(n));
        }
    }

    public static int  getNums(int n){
        int res=0;
        while (n>=3){
            res+=n/3;
            n=n%3+n/3;
        }
        //到这一步n一定小于3
        //如果n==2,那么还可以借一瓶,否则直接返回
        if(n==2){
            res++;
        }
        return res;
    }
}
