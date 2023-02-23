package HashTable;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/22 11:14
 * @description 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 *
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 *
 *
 * 925.长按键入
 **/
public class isLongPressedName_ {
    public boolean isLongPressedName(String name, String typed) {
        int i=0;
        int j=0;
        while (i<name.length()&&j<typed.length()){
            if(name.charAt(i)== typed.charAt(j)){
                j++;
                i++;
            }else{
                if(j==0){
                    return false;
                }
                while (j<typed.length()&&typed.charAt(j)==typed.charAt(j-1)){
                    j++;
                }
                if(name.charAt(i)== typed.charAt(j)){
                    i++;
                    j++;
                }else{
                    return false;
                }
            }
        }
        if(i<name.length()){
            return false;
        }
        while (j<typed.length()){
            if(typed.charAt(j)==typed.charAt(j-1)){
                j++;
            }else{
                return false;
            }
        }
        return true;
    }
}
