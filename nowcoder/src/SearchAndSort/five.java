package SearchAndSort;

import java.util.Arrays;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/6/7 19:52
 * @description 有一个长度为 n 的非降序数组，比如[1,2,3,4,5]，
 * 将它进行旋转，即把一个数组最开始的若干个元素搬到数组的末尾，
 * 变成一个旋转数组，比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的。
 * 请问，给定这样一个旋转数组，求数组中的最小值。
 * 要求：空间复杂度：O(1) ，时间复杂度：O(logn)
 **/
public class five {
    public int minNumberInRotateArray(int [] array) {
        /**
         * 解法一:暴力求解
         * 可以借助Java.util.Arrays
         */
        Arrays.sort(array);
        return array[0];
    }
    public int minNumberInRotateArray1(int [] array){
        /**
         * 解法二:使用分治
         * 4 5 6
         */
        int l=0;
        int r=array.length-1;
        while(l<r){
            int m=(l+r)>>1;
            if(array[m]>array[r]){
                l=m+1;
            }else if(array[m]==array[r]){
                r--;
            }else{
                r=m;
            }
        }
        return array[l];
    }
}
