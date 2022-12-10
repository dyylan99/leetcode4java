package Greed;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/10 14:13
 * @description 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 *
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 *
 * 返回一个表示每个字符串片段的长度的列表。
 *
 * 763. 划分字母区间
 **/
public class partitionLabels_ {
    public List<Integer> partitionLabels(String s) {
        List<Integer>list=new LinkedList<>();
        int[]edge=new int[26];
        char[]chars=s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            edge[chars[i]-'a']=i;
        }
        int idx=0;
        int last=-1;
        for (int i = 0; i < chars.length; i++) {
            idx=Math.max(idx,edge[chars[i]-'a']);
            if(i==idx){
                list.add(i-last);
                last=i;
            }
        }
        return list;
    }


    @Test
    public void test(){
        List<Integer> list = partitionLabels("ababcbacadefegdehijhklij");
        for (Integer integer : list) {
            System.out.print(integer );
        }
    }
}
