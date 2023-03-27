package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/22 15:05
 * @description 剑指 Offer 38. 字符串的排列
 **/
public class permutation_ {
    List<String>list=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        boolean[] used=new boolean[s.length()];
        //Arrays.fill(used,false);
        //必须需要对数组排序
        Arrays.sort(chars);
        backTracking(chars,used);
        return list.toArray(new String[list.size()]);
    }

    private void backTracking(char[]chars,boolean[]used){
        if(sb.length()==chars.length){
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if(i>0&&chars[i]==chars[i-1]&&used[i - 1]){
                continue;
            }
            //没用过
            if(!used[i]){
                used[i]=true;
                sb.append(chars[i]);
                backTracking(chars,used);
                sb.deleteCharAt(sb.length()-1);
                used[i]=false;
            }
        }
    }
}
