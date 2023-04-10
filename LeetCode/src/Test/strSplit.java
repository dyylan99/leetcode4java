package Test;

import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/6 14:58
 * @description TODO
 **/
public class strSplit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        StringBuilder sb=new StringBuilder();
        int count=0;

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            count++;
            if(count%8==0){
                System.out.println(sb);
                sb.delete(0,sb.length());
                count=0;
            }
        }
        while (count!=0&&count<8){
            sb.append(0);
            count++;
            if(count==8){
                System.out.println(sb);
            }
        }
    }
}
