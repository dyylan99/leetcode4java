package cn.dylan.Array;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/12 16:00
 * @description 剑指 Offer 51. 数组中的逆序对
 **/
public class reversePairs_ {
    int count=0;
    public int reversePairs(int[] nums) {
        merge(nums,0,nums.length-1);
        return count;
    }

    public void merge(int[] nums, int left, int right){
        int mid=left+(right-left)>>1;
        if(left<right){
            merge(nums,left,mid);
            merge(nums,mid+1,right);
            mergeSort(nums,left,mid,right);
        }
    }

    public void mergeSort(int[] nums,int left, int mid ,int right){
        int[] tmpArr=new int[right-left+1];
        int index=0;
        int temp1=left, temp2=mid+1;
        while (temp1<=mid && temp2<=right){
            //不是逆序
            if (nums[temp1]<= nums[temp2]){
                tmpArr[index++]=nums[temp1++];
            }else{
                //是逆序, 此时需要统计逆序对的个数
                count+=mid-temp1+1;
                tmpArr[index++]=nums[temp2++];
            }
        }
        //将剩余的元素都放到临时数组中
        while (temp1<=mid){
            tmpArr[index++]=nums[temp1++];
        }
        while (temp2<=right){
            tmpArr[index++]=nums[temp2++];
        }
        
        //将临时数组放到原数组中
        for (int i = 0; i < tmpArr.length; i++) {
            nums[i+left]=tmpArr[i];
        }

    }

}
