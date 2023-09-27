package cn.dylan.dp;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/20 15:04
 * @description 1227. 飞机座位分配概率
 **/
public class nthPersonGetsNthSeat_ {
    public double nthPersonGetsNthSeat(int n) {
        if(n == 1){
            return 1;
        }
        //注意不能直接写 1 / n, 否则结果直接为 0
        return 1.0 / n + (double)(n - 2) / n * nthPersonGetsNthSeat(n - 1);
    }
}
