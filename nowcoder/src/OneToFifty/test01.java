package OneToFifty;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/5/17 20:10
 * @description TODO
 **/
public class test01 {
    /**
     * 本题知识点,异或运算符^,比较两个数对应的的二进制数,相同位数上的值相同则为真,但异或后为0,
     * 不相同则为1;
     * 用于两个量之间的转换
     *
     */
    @Test
    public void test01(){
        int a=1;
        int b=5;
        if(a<b){
            a^=b;
            b^=a;
            a^=b;
        }
        System.out.println((a+b)+" "+(a-b)+" "+(a*b)+" "+(a/b)+" "+(a%b));

    }

    /**
     * 使用Switch case!
     */

    @Test
    public void test02(){
        Scanner scanner = new Scanner(System.in);
        String grade =scanner.next();
        switch(grade){
            case "A":
                System.out.println("优秀");
                break;
            case "B":
                System.out.println("良好");
                break;
            case "C":
                System.out.println("及格");
                break;
            case "D":
                System.out.println("不及格");
                break;
            default:
                System.out.println("未知等级");
                break;
        }
    }
    @Test
    public void test03(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String emailMatcher="[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+";
        if(str.matches(emailMatcher)){
            System.out.println("邮箱输入合法");
        }else{
            System.out.println("邮箱输入不合法");
        }
    }
    @Test
    public void test04()
    {
        long d=0;
        long c=1;
        for(int i=1;i<11;i++){
            c*=10;
            d+=(c-1);
        }
        System.out.println(d);

    }
}
