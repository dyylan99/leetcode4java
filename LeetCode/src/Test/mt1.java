package Test;

import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/16 19:01
 * @description TODO
 **/
public class mt1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades=new int[n];
        for (int i = 0; i < grades.length; i++) {
            grades[i]=in.nextInt();
        }
        int sum=0;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i]==1){
                if (i>0&&grades[i-1]==1){
                    sum+=2;
                }else{
                    sum+=1;
                }
            }
        }
        System.out.println(sum);
    }
}
