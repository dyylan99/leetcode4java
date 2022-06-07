package SearchAndSort;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/6/6 8:09
 * @description 给定一个长度为n的数组nums，请你找到峰值并返回其索引。数组可能包含多个峰值，在这种情况下，返回任何一个所在位置即可。
 * 1.峰值元素是指其值严格大于左右相邻值的元素。严格大于即不能有等于
 * 2.假设 nums[-1] = nums[n] = -\infty−∞
 * 3.对于所有有效的 i 都有 nums[i] != nums[i + 1]
 * 4.你可以使用O(logN)的时间复杂度实现此问题吗？
 **/
public class three {
    public int findPeakElement (int[] nums) {
        //首先特殊情况:
        if(nums.length==0){
            return -1;
        }
        if(nums.length==1||nums[0]>nums[1]){
            return 0;
        }
        for (int i = 1; i <nums.length-1 ; i++) {
            //2 4 1 2 7 8 4
            if(nums[i]>nums[i-1]&&nums[i]>nums[i+1]){
                return i;
            }
        }
        //如果上面的循环未找到峰值,就直接返回最后一个
       return  nums.length-1;

        /**
         * 上面的方法时间复杂度为O(n),不满足进阶要求
         */
    }


    public int findPeakElement1 (int[] nums){
        /**
         * 以时间复杂度O(logN)的角度考虑这个问题
          */
        /**
         * 思路:以二分法解决这个问题,具体做法:
         * 1.首先从数组首尾开始,取中间值
         * 2.若中间值比大于其右边的元素,则说明向右是往下,我们不一定会遇到波峰,应该往左收缩区间
         * 3.若中间值小于右边的元素,则说明往右是向上,我们往上一定能遇到波峰,则向右收缩区间
         * 4.最后区间首尾相遇的点即为波峰
         *
         */
        if(nums.length==0){
            return -1;
        }
        if(nums.length==1||nums[0]>nums[1]){
            return 0;
        }
        int left=0;
        int right=nums.length-1;
        while(left<right) {
            int mid=(left+right)>>1;
            if (nums[mid] <= nums[mid + 1]) {
                left = mid + 1;

            } else if (nums[mid] > nums[mid + 1]) {
                right = mid;
            }
        }
        return right;
    }
}
