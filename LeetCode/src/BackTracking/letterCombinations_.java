package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/1 13:48
 * @description 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 * 17. 电话号码的字母组合
 **/
public class letterCombinations_ {
    List<String>res=new ArrayList<>();
    StringBuilder tem=new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0){
            return res;
        }
        String[] numStrings={
                "",
                "",
                "abc",
                "def",
                "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        backTracking(digits,numStrings,0);
        return res;
    }

    public void backTracking(String digits,String[]numsString,int num){
        if(num==digits.length()){
            res.add(tem.toString());
            return;
        }
        String str=numsString[digits.charAt(num)-'0'];
        for(int i=0;i<str.length();i++){
            tem.append(str.charAt(i));
            backTracking(digits,numsString,num+1);
            tem.deleteCharAt(tem.length()-1);
        }
    }

}
