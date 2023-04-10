package Test;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/7 17:04
 * @description TODO
 **/
public class removePosition {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String str = sc.nextLine();

        String[] strings = str.split(";");
        int x=0,y=0;
        for (String string : strings) {
            if (isValid(string)){
                int i = Integer.parseInt(string.substring(1));
                if(string.charAt(0)=='A'){
                    x-=i;
                }else if(string.charAt(0)=='S'){
                    y-=i;
                }else if(string.charAt(0)=='D'){
                    x+=i;
                }else{
                    y+=i;
                }
            }
        }
        System.out.println(x+","+y);
    }


    public static boolean isValid(String s){
        if(s.length()==0){
            return false;
        }
        if(s.charAt(0)!='A'&&s.charAt(0)!='S'&&s.charAt(0)!='W'&&s.charAt(0)!='D'){
            return false;
        }
        //是否是数字  -?[0-9]+.?[0-9]* --->小数,负数都能判断
        return s.substring(1).matches("[0-9]+");
    }

    @Test
    public void test(){
        System.out.println(Integer.parseInt("-927"));
    }
}
