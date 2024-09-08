package Tree;

import org.junit.Test;

/**
 * @author panyuhang
 * @version 1.0
 * @description TODO
 * @since 2024/9/8 12:49
 **/
public class heapSort {
    public int[] sortArray(int[] nums) {
        //堆化
        int n=nums.length;
        //首先从最后一个非叶子节点开始进行下沉操作
        for (int i = n/2-1; i>=0 ; i--) {
            siftDown(nums,n,i);
        }
        return HeapSort(nums);
    }

    public int[] HeapSort(int[] nums){
        int n=nums.length;
        for (int i = n-1; i >0 ; i--) {
            //将第一个元素和最后一个元素交换, 交换后, heapSize减一
            swap(nums,0,i);
            //下沉交换后的根节点
            siftDown(nums,i,0);
        }
        return nums;
    }

    //将下标为k的节点进行下沉
    private void siftDown(int[] nums,int heapSize,int k){
        //非叶子结点需要一直尝试下沉
        while (k<heapSize/2){
            int largest=k*2+1;
            int right=k*2+2;
            if (right<heapSize && nums[right]>nums[largest]){
                largest=right;
            }
            if (nums[k]>=nums[largest])break;
            swap(nums,k,largest);
            k=largest;
        }
    }
    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    @Test
    public void test(){
        int[] ints = sortArray(new int[]{5, 5, 6, 8, 7, 2, 1});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }


}
