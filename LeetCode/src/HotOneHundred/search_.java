package HotOneHundred;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/1 9:56
 * @description TODO
 *
 * 33. 搜索旋转排序数组
 **/
public class search_ {
    public int search(int[] nums, int target) {
        /**
         * 旋转数组从中间切两半, 其中一半必定是有序递增的数组
         */
        /**
         * 逆转数组的查找效率要想达到logn显然需要用二分法。
         * 观察可知 若将逆转数组若分成相对对称的两段，其中必有一段为有序区间，而另一段则可能为无序区间
         * 判断一个值是否在无序区间需要遍历，而判断一个值是否在有序区间却只需要将target与两端进行比较即可
         * 而逆转数组的无序段和有序段的一个显著标志就是段头是否小于段尾 因此本题的算法应该是将数组不断二分，在每一次二分的过程中，先找到有序区间，
         * 然后若通过对比发现target在有序区间，那另一端可以直接舍弃；否则就完全可以将有序区间舍弃
         */
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[left]<=nums[mid]){
                if(target>nums[mid]||target<nums[left]){
                    left=mid+1;
                }else{
                    right=mid;
                }
            }else{
                if(target>nums[right]||target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid;
                }
            }
        }
        return nums[right]==target?right:-1;
    }
}
