package offer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/17 13:40
 * @description 剑指 Offer 17. 打印从1到最大的n位数
 **/
public class printNumbers_ {
    public int[] printNumbers(int n) {
        int to=9;
        for (int i = 1; i <n; i++) {
            to=to*10+9;
        }
        int []res=new int[to];
        for (int i = 0; i < to; i++) {
            res[i]=i+1;
        }
        return res;
    }
}
