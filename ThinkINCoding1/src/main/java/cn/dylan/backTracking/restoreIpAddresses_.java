package cn.dylan.backTracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/10/10 11:24
 * @description 93.复原ip地址
 **/
public class restoreIpAddresses_ {
    List<String>res;
    List<String>path;
    public List<String> restoreIpAddresses(String s) {
        path=new ArrayList<>();
        res=new ArrayList<>();
        backTracking(s,0);
        return res;
    }
    private void backTracking(String s,int startIdx){
        if (path.size()>4){
            return;
        }
        if (path.size()==4 && startIdx==s.length()){ //必须确保路径数组的长度是4个并且已经走到了字符串的末尾
            res.add(path.get(0)+"."+path.get(1)+"."+path.get(2)+"."+path.get(3));
            return;
        }
        for (int i = startIdx; i < s.length(); i++) {
            if (i-startIdx>3){
                break;
            }
            if (i>startIdx&&s.charAt(startIdx)=='0'){ //去除前导0
                break;
            }
            int num=Integer.parseInt(s.substring(startIdx,i+1));
            if(num>0 && num<=255){
                path.add(num+"");
                backTracking(s,i+1);
                path.remove(path.size()-1);
            }
        }
    }
    @Test
    public void test(){
        System.out.println(restoreIpAddresses("0000"));
    }

}
