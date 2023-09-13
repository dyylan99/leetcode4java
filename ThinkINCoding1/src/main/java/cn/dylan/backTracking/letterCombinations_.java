package cn.dylan.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/13 14:15
 * @description 17. 电话号码的字母组合
 **/
public class letterCombinations_ {
    List<String>res=new ArrayList<>();
    StringBuilder sb=new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits==null || digits.isEmpty()){
            return res;
        }
        String[] nums={"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits,nums,0);
        return res;
    }

    private void backTracking(String digits, String[] nums,int num){
        if (num==digits.length()){
            res.add(sb.toString());
            return;
        }

        String str=nums[digits.charAt(num)-'0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backTracking(digits,nums,num+1);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
