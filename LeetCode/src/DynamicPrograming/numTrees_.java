package DynamicPrograming;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/15 13:30
 * @description 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数
 *
 * 96. 不同的二叉搜索树
 **/
public class numTrees_ {
    public int numTrees(int n) {
        int[]dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
