package Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/26 12:03
 * @description TODO
 **/
public class PassNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int m = in.nextInt();
            int x = in.nextInt();
            int[]scores=new int[m];
            for(int i=0;i<m;i++){
                scores[i]=in.nextInt();
            }
            System.out.println(passNum(x,scores));
        }
    }
    public static int passNum(int x,int[]scores){
        if(x==0||scores.length==0){
            return 0;
        }
        Arrays.sort(scores);

        if(x>=scores.length){
            int count=0;
            for(int i:scores){
                if(i>0){
                    count++;
                }
            }
            return count;
        }
        int count=0;
        for(int i=scores.length-1;i>=scores.length-x;i--){
            if(scores[i]>=scores[scores.length-x]&&scores[i]>0){
                count++;
            }
        }
        return count;
    }
}
