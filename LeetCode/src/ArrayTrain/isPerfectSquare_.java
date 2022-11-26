package ArrayTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/26 14:28
 * @description 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 *
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 *
 * 367. 有效的完全平方数
 **/
public class isPerfectSquare_ {
    public boolean isPerfectSquare(int num) {
        if(num==1){
            return true;
        }
        int min=0;
        int max=num;
        while (max-min>1){
            int m=(max+min)/2;
            if(num/m<m){
                max=m;
            }else{
                min=m;
            }
        }
        if(min*min==num){
            return true;
        }else{
            return false;
        }
    }
}
