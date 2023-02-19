package ArrayTrain;

import java.util.Arrays;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/19 12:20
 * @description 给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 arr 满足下述条件，那么它是一个山脉数组：
 *
 * arr.length >= 3
 * 在 0 < i < arr.length - 1 条件下，存在 i 使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 *
 * 941. 有效的山脉数组
 **/
public class validMountainArray_ {
    //山脉数组: 先递增然后递减
    public boolean validMountainArray(int[] arr) {
            if(arr.length<3){
                return false;
            }
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr1);
        int max=arr1[arr.length-1];
        int index=0;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]==max&&i!=0){
                index=i;
                break;
            }
            if(arr[i]<arr[i+1]){
                continue;
            }else{
                return false;
            }
        }
        for (int i = index; i <arr.length-1 ; i++) {
            if(arr[i+1]<arr[i]){
            }else{
                return false;
            }
        }
        return true;
    }

    //双指针解法
    public boolean validMountainArray1(int[] arr){
        if(arr.length<3){
            return false;
        }
        int index1=0;
        int index2=arr.length-1;
       while (index1<arr.length-1&&arr[index1]<arr[index1+1]){
           index1++;
       }
        while (index2>0&&arr[index2]<arr[index2-1]){
            index2--;
        }
        if(index1==index2&&index1!=0&&index2!=arr.length-1){
            return true;
        }
        return false;
    }
}
