package DynamicPrograming;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/19 18:51
 * @description 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。
 *
 * 请你判断是否可以利用字典中出现的单词拼接出 s 。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * 139. 单词拆分
 **/
public class wordBreak_ {
    //分析:
    //因为wordDict中的单词可以重复使用,并且判断的是wordDict中的单词是否可以组成s,
    //说明这是一个完全背包问题
    //显然,单词的顺序会影响到s的构成, 所以这也是一个排列问题
    //排列问题: 先遍历背包,再遍历物品
    public boolean wordBreak(String s, List<String> wordDict) {
        //dp[i] : 字符串长度为i的话，dp[i]为true，表示可以拆分为一个或多个在字典中出现的单词。
        int len=s.length();
        HashSet<String>set=new HashSet<>(wordDict);
        boolean[]dp=new boolean[len+1];
        //如果dp[j]是true, 那么在[j,i]这个区间里的单词出现在wordDict中, 那么dp[i]就为true
        dp[0]=true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <i&&!dp[i]; j++) {
                if(set.contains(s.substring(j,i))&&dp[j]){
                    dp[i]=true;
                }
            }
        }
        return dp[len];
    }


    @Test
    public void test(){
        String s="leetcode";
        List<String>wordDict=new ArrayList<>(Arrays.asList("leet","code"));
        wordBreak(s,wordDict);
    }
}
