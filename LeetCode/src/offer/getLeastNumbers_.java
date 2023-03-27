package offer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/22 15:38
 * @description TODO
 **/
public class getLeastNumbers_ {
    public int[] getLeastNumbers1(int[] arr, int k) {
        quickSort(arr,0,arr.length-1);
        int[]res=new int[k];
        for (int i = 0; i < k; i++) {
            res[i]=arr[i];
        }
        return res;
    }
    /**
     * 手写快速排序
     */
    private void quickSort(int[]arr,int start, int end){
        if(start<end){
            int partition = partition(arr, start, end);
            quickSort(arr,start,partition-1);
            quickSort(arr,partition+1,end);
        }
    }

    private int partition(int nums[], int left, int right){
        int midNums=middle(nums,left,(left+right)/2,right);
        //将中位数交换到数组最左端
        swap(nums,left,midNums);
        //以nums[left]作为基准数
        int i=left,j=right;
        while (i<j){
            while (i<j&&nums[j]>=nums[left]){
                j--;
            }
            while (i<j&&nums[i]<=nums[left]){
                i++;
            }

            swap(nums,i,j);
        }
        swap(nums,i,left);
        return i;
    }

    /**
     * 取三个数的中位数
     */
    private int middle(int[]nums,int left,int mid, int right){
        if((nums[left]<nums[mid])^(nums[left]<nums[right])){
            return left;
        }else if((nums[right]<nums[mid])^(nums[right]<nums[left])){
            return right;
        }else{
            return mid;
        }
    }
    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        int[]res=new int[k];
        int[] count=new int[10001];
        for (int i : arr) {
            count[i]++;
        }
        int index=0;
        for (int i = 0; i < count.length&&index<k; i++) {
            //可能会有重复的数
            while(count[i]!=0&&index<k){
                res[index]=i;
                index++;
                count[i]--;
            }
        }
        return res;
    }
}
