package StringAddress;

import org.junit.Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/8 15:13
 * @description 字符串转换整数 (atoi)
 **/
public class myAtoi {


    public int myAtoi(String s) {
        if (s.length()==0){
            return 0;
        }
        //丢弃前导空格
        int i;
        for (i = 0; i < s.length(); i++) {
            if(s.charAt(i)!=' '){
                break;
            }
        }
        s=s.substring(i);
        if (s.length()==0){
            return 0;
        }

        //判断第一个字符是+还是-,或者说没有
        boolean isNegative=false;
        int index=0;
        if(s.charAt(index)=='-'){
            isNegative=true;
            index++;
        }else if(s.charAt(index)=='+'){
            index++;
        }
        //遍历数字
        StringBuilder sb=new StringBuilder();
        while (index<s.length()){
            if(s.charAt(index)>='0'&&s.charAt(index)<='9'){
                //是数字需要判断当前数是否超过限定值
                if(sb.length()<9||Integer.parseInt(sb.toString())<214748364){
                    sb.append(s.charAt(index++));
                    continue;
                }
                    if(Integer.parseInt(sb.toString())==214748364&&s.charAt(index)<='7'){
                        sb.append(s.charAt(index++));
                    }else{
                        if(isNegative){
                             return Integer.MIN_VALUE;
                        }else{
                            return Integer.MAX_VALUE;
                        }
                    }
            }else {
                break;
            }

        }
        if(sb.length()==0){
            return 0;
        }

        int res=Integer.parseInt(sb.toString());
        return isNegative?-res:res;
    }

    @Test
    public void test(){
        System.out.println(myAtoi("  -984245821455484a8dwad"));
        System.out.println(Integer.MAX_VALUE);
    }
}
