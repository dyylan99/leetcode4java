package Test;

import org.junit.Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/2 11:25
 * @description 数组的快速排序
 **/
public class testQuickSort {

    //快速排序,需要选定中间数使其不是极端例子
    public int partition(int[]nums,int left,int right){
        //根据哨兵选定基准数
        int mid=(left+right)/2;
        //中间数的索引
        int midIndex = midNum(nums, left, mid, right);
        //将中间数换到最左边
        swap(nums,left,midIndex);
        int i=left,j=right;
        while (i<j){
            //从右向左找到首个小于基准数的位置
            while (i<j&&nums[j]>=nums[left]){
                j--;
            }
            //从左向右找到首个大于基准数的数
            while (i<j&&nums[i]<=nums[left]){
                i++;
            }
            //交换
            swap(nums,i,j);
        }
        swap(nums,i,left);
        //返回该数正确的位置下标
        return i;
    }


    //为了避免极端情况,选定中间数
    public int midNum(int[]nums,int left,int mid,int right){
        if(nums[left]<nums[right]^nums[left]<nums[mid]){
            return left;
        }else if (nums[right]<nums[left]^nums[right]<nums[mid]){
            return right;
        }else{
            return mid;
        }
    }

    public void quickSort(int[]nums,int start,int end){
        if(start<end){

            int q = partition(nums, start, end);
            quickSort(nums,start,q-1);
            quickSort(nums,q+1,end);
        }
    }

    @Test
    public void test(){
        int[]nums=new int[]{1,3,10,4,6,45,-8,33};
        quickSort(nums,0,nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
