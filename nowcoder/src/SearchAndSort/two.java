package SearchAndSort;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/6/6 8:03
 * @description 在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 **/
public class two {
    /**
     *下面的这个函数,利用到了二维数组从左到右,从上到下依次递增的特性
     */
    public boolean Find(int target, int [][] array) {
        if(array.length==0||array[0].length==0){
            return  false;
        }
        int n=array.length-1;
        int m=array[0].length-1;
        for (int i=0,j=n;i<=m&&j>=0;){
            if(target==array[j][i]){
                return true;
            }
            if(target>array[j][i]){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
    public boolean Find1(int target, int [][] array) {
        /**
         * 该函数只利用到了二维数组从左到右依次递增,利用二分法查找的方法
         */
        boolean isFind=false;
        for (int[] ints : array) {
            int t = search(ints, target);
            if (t != -1) {
                isFind = true;
            }
        }
        return isFind;
    }
    public int search (int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=(left+right)>>1;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
}
