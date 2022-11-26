package ArrayTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/26 14:05
 * @description 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 *
 * 69. x 的平方根
 **/
public class mySqrt_ {
    public int mySqrt(int x) {
        //if (x==0||x==1){
        //    return x;
        //}
        //for (int i = 0; i < x/2; i++) {
        //    if(i*i<=x&&(i+1)*(i+1)>x){       //在这一步溢出了
        //        return i;
        //    }
        //}
        //return -1;


        //二分查找，用x/m<m而不是m*m>x防止溢出
        if(x == 1)
            return 1;
        int min = 0;
        int max = x;
        while(max-min>1)
        {
            int m = (max+min)/2;
            if(x/m<m)
                max = m;
            else
                min = m;
        }
        return min;
    }


}
