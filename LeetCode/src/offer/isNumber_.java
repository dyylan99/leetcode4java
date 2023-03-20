package offer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/18 12:03
 * @description 剑指 Offer 20. 表示数值的字符串
 **/
public class isNumber_ {
    public boolean isNumber(String s) {
        if(s==null||s.length()==0){
            return false;
        }
        //去掉首尾空格
        s=s.trim();
        boolean numFlag=false;
        boolean dotFlag=false;
        boolean eFlag=false;
        for (int i = 0; i < s.length(); i++) {
            //判定为数字,则标记numFlag
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                numFlag=true;
            }else if(s.charAt(i)=='.'&&!dotFlag&&!eFlag){
                //位置i是 . ,且没出现过.和e  因为只能有一个小数点
                dotFlag=true;
            }else if((s.charAt(i)=='e'||s.charAt(i)=='E')&&!eFlag&&numFlag){
                eFlag=true;
                numFlag=false;  //为了避免 12e这种情况,出现了e就需要将numFlag标记为false
            }else if((s.charAt(i)=='+'||s.charAt(i)=='-')&&(i==0||s.charAt(i-1)=='e'||s.charAt(i-1)=='E')){
                            //后面面一位是+或-,前面面一位是e或者E或者i就在第一位,合法
            }else{
                return false;
            }

        }
        return numFlag;
    }
}
