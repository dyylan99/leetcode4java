package Greed;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/8 10:47
 * @description 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 45. 跳跃游戏 II
 **/
public class jump_ {
    public int jump(int[] nums) {
       int cur=0;
       int count=0;
       int nextDistance=0;
        for (int i = 0; i < nums.length-1; i++) {
            nextDistance=Math.max(nums[i]+i, nextDistance);
            if(i==cur){
                cur=nextDistance;
                count++;
            }

        }
        return count;
    }
}
