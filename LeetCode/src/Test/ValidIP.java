package Test;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/8 13:27
 * @description TODO
 **/
public class ValidIP {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int a=0,b=0,c=0,d=0,e=0,err=0,p=0;

        while (sc.hasNextLine()){
            String s = sc.nextLine();

            String[] strings = s.split("~");
            int ipFirst = getIpSegment(strings[0], 0);
            //该范围的ip忽略统计
            if(ipFirst==0||ipFirst==127){
                continue;
            }
            if(!maskIsValid(strings[1])){
                err++;
                continue;
            }
            if(ipIsInvaild(strings[0])){
                err++;
                continue;
            }
            if (ipFirst >= 1 && ipFirst <= 126) {
                a++;
            }
            if (ipFirst >= 128 && ipFirst <= 191) {
                b++;
            }
            if (ipFirst >= 192 && ipFirst <= 223) {
                c++;
            }
            if (ipFirst >= 224 && ipFirst <= 239) {
                d++;
            }
            if (ipFirst >= 240 && ipFirst <= 255) {
                e++;
            }
            int ipSecond = getIpSegment(strings[0], 1);
            if (ipFirst == 10 || (ipFirst == 172 && ipSecond >= 16 && ipSecond <=31) || (ipFirst == 192 && ipSecond == 168)) {
                p++;
            }
        }
        System.out.println(a+" "+b+" "+c+" "+d+" "+e+" "+err+" "+p);
    }
    public static boolean ipIsInvaild(String ip) {
        String[] ipArr = ip.split("\\.");
        if (ipArr.length != 4) {
            return true;
        }
        if (Integer.parseInt(ipArr[0]) > 255 || Integer.parseInt(ipArr[1]) > 255 || Integer.parseInt(ipArr[2]) > 255 || Integer.parseInt(ipArr[3]) > 255) {
            return true;
        }
        return false;
    }

    public static boolean maskIsValid(String mask){
        String[] strings = mask.split("\\.");

        if(strings.length!=4){
            return false;
        }
        String maskBinary=toBinary(strings[0])+toBinary(strings[1])+toBinary(strings[2])+toBinary(strings[3]);
        //{n,}--->n是一个非负整数。至少匹配n次。例如，“o{2,}”不能匹配“Bob”中的“o”，但能匹配“foooood”中的所有o。“o{1,}”等价于“o+”。“o{0,}”则等价于“o*”。
        if(!maskBinary.matches("[1]{1,}[0]{1,}")){
            return false;
        }
        return true;
    }
    //字符串转二进制
    public static String toBinary(String num) {
        String numBinary = Integer.toBinaryString(Integer.parseInt(num));
        while (numBinary.length() < 8) {
            numBinary = "0" + numBinary;
        }
        return numBinary;
    }

    public static int getIpSegment(String ip,int index){
        String[] ipArr = ip.split("\\.");

        return Integer.parseInt(ipArr[index]);
    }
    @Test
    public void test(){
        String s="2";
        String numBinary = Integer.toBinaryString(Integer.parseInt(s));
        System.out.println(numBinary);
        //高位补0
        while (numBinary.length()<8){
            numBinary="0"+numBinary;
        }
        System.out.println(numBinary);
    }
}
