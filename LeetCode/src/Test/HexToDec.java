package Test;

import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/10 15:36
 * @description 十六进制转化为十进制的方法,从末位开始,到第二位前,每一位乘16的次方, 但是注意字母的表示
 **/
public class HexToDec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String num = str.substring(2);
            int result = 0;
            int power = 1;
            for (int i = num.length() - 1; i >= 0; i--) {
                char c = num.charAt(i);
                if (c >= '0' && c <= '9') {
                    result += (c - '0') * power;
                } else if (c >= 'A' && c <= 'F') {
                    result += (c - 'A' + 10) * power;
                }
                power *= 16;
            }
            System.out.println(result);
        }
    }
}
