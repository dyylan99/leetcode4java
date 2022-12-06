package Greed;

import java.util.Arrays;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/6 14:14
 * @description 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 *
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；
 * 并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，
 * 这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 *455. 分发饼干
 **/
public class findContentChildren_ {

    public int findContentChildren(int[] g, int[] s) {
        //小饼干先喂饱小胃口
        //先将数组升序排序
        Arrays.sort(g);
        Arrays.sort(s);
        int start=0;
        int count=0;
        for (int i=0;i<s.length&&start<g.length;i++){
            if(s[i]>=g[start]){
                start++;
                count++;
            }
        }
        return count;
    }
}
