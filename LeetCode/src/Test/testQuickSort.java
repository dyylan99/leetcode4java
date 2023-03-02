package Test;

import org.junit.Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/2 11:25
 * @description TODO
 **/
public class testQuickSort {
    public int partition(int[]nums,int p,int r){
        int x=nums[r];
        int i=p-1;
        for (int j = p; j <r ; j++) {
            if(nums[j]<=x){
                ++i;
                swap(nums,i,j);
            }
        }
        swap(nums,i+1,r);
        return i+1;
    }

    @Test
    public void test(){
        int[]nums=new int[]{1,3,10,4,6};
        quickSort(nums,0,nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public void quickSort(int[]nums,int start,int end){
        if(start<end){
            int q = partition(nums, start, end);
            quickSort(nums,start,q-1);
            quickSort(nums,q+1,end);
        }
    }

    public void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
