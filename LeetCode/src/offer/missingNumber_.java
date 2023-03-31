package offer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/27 16:24
 * @description 剑指 Offer 53 - II. 0～n-1中缺失的数字
 **/
public class missingNumber_ {
    public int missingNumber(int[] nums) {
        /**
         * 二分查找
         */
        int l = 0, h = nums.length-1, m = (l+h)/2;

        while (l <= h) {
            if (m != nums[m]) { // 缺失的数字在m位置前
                h = m-1;
            } else { // 缺失的数字在m位置后
                l = m+1;
            }
            m = (l+h)/2;
        }

        return l;
    }
}
