package cn.dylan.Array.DynamicProgram;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/12 17:15
 * @description 5. 最长回文子串
 **/
public class longestPalindrome_ {
    public String longestPalindrome(String s) {
        /**
         * 确定dp数组（dp table）以及下标的含义
         * 布尔类型的dp[i][j]：表示区间范围[i,j] （注意是左闭右闭）的子串是否是回文子串，如果是dp[i][j]为true，否则为false。
         *
         * 确定递推公式
         * 在确定递推公式时，就要分析如下几种情况。
         *
         * 整体上是两种，就是s[i]与s[j]相等，s[i]与s[j]不相等这两种。
         *
         * 当s[i]与s[j]不相等，那没啥好说的了，dp[i][j]一定是false。
         *
         * 当s[i]与s[j]相等时，这就复杂一些了，有如下三种情况
         *
         * 情况一：下标i 与 j相同，同一个字符例如a，当然是回文子串
         * 情况二：下标i 与 j相差为1，例如aa，也是文子串
         * 情况三：下标：i 与 j相差大于1的时候，例如cabac，此时s[i]与s[j]已经相同了，
         * 我们看i到j区间是不是回文子串就看aba是不是回文就可以了，那么aba的区间就是 i+1 与 j-1区间，这个区间是不是回文就看dp[i + 1][j - 1]是否为true。
         */
        int left=0;
        int right=0;
        int res=1;
        //dp[i][j]是bool类型的, 代表下标为[i,j]范围内的字符串是否是回文子串
        boolean[][] dp=new boolean[s.length()][s.length()];
        //dp[0][0]为true, dp[k][k]都为true

        for (int i = 0; i < s.length(); i++) {
            dp[i][i]=true;
        }
        for (int i = s.length()-1; i>=0; i--) {
            for (int j = i; j < s.length(); j++) {
                boolean b = s.charAt(i) == s.charAt(j);
                if (b){
                    if (j-i<=1 || dp[i+1][j-1]){
                        dp[i][j]=true;
                    }
                }
                if (dp[i][j] && j-i+1>res){
                    res=j-i+1;
                    left=i;
                    right=j;
                }

            }
        }
        return s.substring(left,right+1);
    }
}
