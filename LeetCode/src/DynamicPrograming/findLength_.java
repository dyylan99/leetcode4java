package DynamicPrograming;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/1/3 14:52
 * @description 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 *
 * 718. 最长重复子数组
 **/
public class findLength_ {
    public int findLength(int[] nums1, int[] nums2) {
        //dp[i][j] ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度为dp[i][j]。
        //当nums1[i-1]==nums2[j-1]时,dp[i][j]=dp[i-1][j-1]+1
        int[][]dp=new int[nums1.length+1][nums2.length+1];
        dp[0][0]=0;
        int res=0;
        for (int i = 1; i <=nums1.length ; i++) {
            for (int j = 1; j <=nums2.length ; j++) {
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                if(res<dp[i][j]){
                    res=dp[i][j];
                }
            }
        }
        return res;
    }
}
