package Greed;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/8 10:27
 * @description 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 * 55. 跳跃游戏
 **/
public class canJump_ {

    public boolean canJump(int[] nums) {
        int length=nums.length;
        if(length==1){
            return true;
        }
        int cover=0;
        for (int i = 0; i <= cover; i++) {
            cover=Math.max(i+nums[i],cover);
            if(cover>=length-1){
                return true;
            }
        }
        return false;
    }
}
