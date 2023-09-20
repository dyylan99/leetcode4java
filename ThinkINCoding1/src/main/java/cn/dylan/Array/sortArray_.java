package cn.dylan.Array;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/15 15:13
 * @description 912. 排序数组
 **/
public class sortArray_ {
    public int[] sortArray(int[] nums) {
        if (nums.length<=1){
            return nums;
        }
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    private void quickSort(int []nums,int start,int end){
        if (start<end){
            int partition = partition(nums, start, end);
            quickSort(nums,start,partition-1);
            quickSort(nums,partition+1,end);

        }
    }
    private int partition(int[]nums,int left,int right){
        int mid=medianThree(nums,left,(left+right)/2,right);
        //将left交换到最左端
        swap(nums,left,mid);
        int i=left,j=right;
        while (i<j){
            while (i<j && nums[j]>=nums[left]){
                j--;
            }
            while (i<j && nums[i]<=nums[left]){
                i++;
            }
            swap(nums,i,j);
        }
        swap(nums,i,left);
        return i;
    }


    /* 选取三个元素的中位数 */
    private int medianThree(int[] nums, int left, int mid, int right) {
        // 此处使用异或运算来简化代码
        // 异或规则为 0 ^ 0 = 1 ^ 1 = 0, 0 ^ 1 = 1 ^ 0 = 1
        if ((nums[left] < nums[mid]) ^ (nums[left] < nums[right]))
            return left;
        else if ((nums[mid] < nums[left]) ^ (nums[mid] < nums[right]))
            return mid;
        else
            return right;
    }
    public void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }



}
