package BackTracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/2 14:22
 * @description 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。
 * 你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 * 93. 复原 IP 地址
 **/
public class restoreIpAddresses_ {

    List<String>res=new ArrayList<>();

    StringBuilder sb=new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        if (s.length()>12){
            return res;
        }
        backTracking(s,0,0);
        return res;
    }

    void backTracking(String s,int startIndex,int pointNum){
        if(pointNum==3){
            if(isIp(s,startIndex,s.length()-1)){
                res.add(s);
            }
            return;
    }
       for (int i=startIndex;i<s.length();i++){
            if(isIp(s,startIndex,i)){
               s=s.substring(0,i+1)+"."+s.substring(i+1);
               pointNum++;
               backTracking(s,i+2,pointNum);
               pointNum--;
               s=s.substring(0,i+1)+s.substring(i+2);
            }else{
                break;
            }
       }

    }

    boolean isIp(String s,int start,int end){
      if(start>end){
          return false;
      }
      if(s.charAt(start)=='0'&&start!=end){
          return false;
      }
      int num=0;
    for (int i = start; i <=end ; i++) {
        if(s.charAt(i)>'9'||s.charAt(i)<'0'){
            return false;
        }
        num=num*10+(s.charAt(i)-'0');
        if(num>255){
            return false;
        }
    }
        return true;
    }


    //优化版本
    public void restoreIpAddressesHandler(String s,int start,int num){
        if(start==s.length()&&num==4){
            res.add(sb.toString());
            return;
        }
        if(start==s.length()||num==4){
            return;
        }
        for (int i=start;i<s.length()&&i-start<3&&Integer.parseInt(s.substring(start,i+1))>=0
                && Integer.parseInt(s.substring(start, i + 1)) <= 255; i++){
            if (i + 1 - start > 1 && s.charAt(start) - '0' == 0) {
                continue;
            }
            sb.append(s.substring(start,i+1));
            if(num<3){
                sb.append(".");
            }
            num++;
            restoreIpAddressesHandler(s,i+1,num);
            num--;
            //todo 重点理解这句代码
            sb.delete(start+num,i+num+2);
        }
    }


    @Test
    public void test(){
        String s="101023";
        restoreIpAddressesHandler(s,0,0);
        for (String re : res) {
            System.out.println(re);
        }
    }
}
