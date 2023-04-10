package Test;

import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/7 15:57
 * @description TODO
 **/
public class Password {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        while (sc.hasNextLine()){
            String password = sc.nextLine();

            if(isValid(password)){
                System.out.println("OK");
            }else{
                System.out.println("NG");
            }
        }
    }

    public static boolean isValid(String password){
        int a=0,b=0,c=0,d=0;
        //密码合格,则返回true
        //否则返回false
        //长度超过8
        if(password.length()<8){
            return false;
        }
        boolean err=true;
        //a数字  b小写字母 c大写字母 d 非空格和换行的字符
        char[] chars = password.toCharArray();
        for (char aChar : chars) {
            if(aChar-'0'>=0&&aChar-'9'<=0){
                //数字
                a=1;
            }else if(aChar>='a'&&aChar<='z'){
                b=1;
            }else if(aChar>='A'&&aChar<='Z'){
                c=1;
            }else if(aChar==' '|| aChar=='\n'){
                err=false;
                break;
            }else{
                d=1;
            }
        }
        if(err){
            if((a+b+c+d)>=3){
                if(reStr(password)){
                    return true;
                }else{
                    //存在重复
                    return false;
                }
            }else{
                //类型小于三种
                return false;
            }
        }else {
            //存在空格或者换行
            return false;
        }

    }

    private static boolean reStr(String s){
        for (int i = 3; i < s.length(); i++) {
            if(s.substring(i).contains(s.substring(i-3,i))){
                return false;
            }
        }
        return true;
    }
}
