package Bit;

/**
 * @author Dylan
 * @version 1.0
 * @date 2024/5/17 16:47
 * @description TODO
 **/
public class isUnique_ {
    public boolean isUnique(String astr) {
        int mask=0;
        for (int i = 0; i < astr.length(); i++) {
            int c=astr.charAt(i)-'a';
             if((mask&(1<<c))!=0){
                 return false;
             }else{
                 //在该位置上置为1
                 mask|=(1<<c);
             }
        }
        return true;
    }
}
