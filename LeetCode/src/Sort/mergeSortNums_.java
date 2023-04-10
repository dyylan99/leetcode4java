package Sort;

import org.junit.Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/8 21:33
 * @description 归并排序
 **/
public class mergeSortNums_ {

    public  void mergeSort(int[] a, int low, int high) {
        //首先判断 low 和 high是否指向一个地方
        if(low >= high) {
            return;
        }
        int mid = (low + high)/2;
        //先递归左边
        mergeSort(a, low, mid);
        //再递归右边
        mergeSort(a, mid+1, high);
        //合并
        merge(a,low,mid,high);
    }
    //合并
    public  void merge(int[] a,int low,int mid,int high) {
        //定义第一段
        int s1 = low;
        //定义第二段
        int s2 = mid+1;
        //定义临时数组
        int[] temp =new int[high-low+1];
        int i = 0;

       //排序,放入数组
        while (s1<=mid&&s2<=high){
            if(a[s1]<a[s2]){
                temp[i++]=a[s1++];
            }else {
                temp[i++]=a[s2++];
            }
        }
        //判断s1,s2是否有数据，放入临时数组
        while(s1<=mid) {
            temp[i++]=a[s1++];
        }
        while(s2<=high) {
            temp[i++]=a[s2++];
        }
        for(int j = 0;j < temp.length;j++) {
            a[j+low]=temp[j];
        }
    }

    @Test
    public void test(){
        int[]nums=new int[]{5,8,3,1,4,6,7,11,25,4};
        mergeSort(nums,0,nums.length-1);
        for (int num : nums) {
            System.out.print(" "+num);
        }
    }
}
