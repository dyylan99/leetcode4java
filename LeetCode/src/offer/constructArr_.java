package offer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/31 14:03
 * @description 剑指 Offer 66. 构建乘积数组
 **/
public class constructArr_ {
    public int[] constructArr(int[] a) {
        int len=a.length;
        int[]res=new int[len];
        //从左往右乘,这一步res[i]为i之前的累成结果
        for (int i = 0,tmp=1; i <len ;tmp*=a[i],i++) {
            res[i]=tmp;
        }
        //从右往左乘,这一步乘的数都是i右边的
        for (int i =len-1,tmp=1; i>=0;tmp*=a[i],i++) {
            res[i]*=tmp;
        }

        return res;
    }
}
