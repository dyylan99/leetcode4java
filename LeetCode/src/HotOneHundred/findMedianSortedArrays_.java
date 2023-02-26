package HotOneHundred;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/26 12:50
 * @description TODO
 *
 * 4. 寻找两个正序数组的中位数
 **/
public class findMedianSortedArrays_ {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //大数组准备
        int i1=nums1.length-1;
        int i2=nums2.length-1;
        int i=i1+i2+1;
        int[] nums = new int[i+1];
        //合成大数组算法
        while(i!=-1){
            if(i1<0)
                nums[i--]=nums2[i2--];
            else if(i2<0)
                nums[i--]=nums1[i1--];
            else if(nums1[i1]>nums2[i2])
                nums[i--]=nums1[i1--];
            else
                nums[i--]=nums2[i2--];
        }
        int len = nums.length;

        //最终计算所得值（提示：len&1==0相当于len%2==0，但是因为是位运算，所以效率要高一些）
        return (len%2)==0?(nums[len/2-1]+nums[len/2])/2.0:nums[len/2];
    }
}
