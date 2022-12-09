package Greed;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/9 14:09
 * @description 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 *
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 *
 * 注意，一开始你手头没有任何零钱。
 *
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 *
 * 860. 柠檬水找零
 **/
public class lemonadeChange_ {
    public boolean lemonadeChange(int[] bills) {
        //两个计数器,存储5美元和十美元的数量
        //收到五美元,直接+1
        //收到十美元,需要查询存储五美元的数组的余量,若小于1,则返回false
        //遇到20美元,先查找是否有一张10美元和1张五美元,若没有则再查找是否有三张五美元,都没有则返回false
       int five=0;
       int ten=0;
        for (int i = 0; i < bills.length; i++) {
            if(bills[i]==5){
                five++;
            }
            if(bills[i]==10){
                if(five<1){
                    return false;
                }else{
                    five--;
                    ten++;
                }
            }
            if(bills[i]==20){
                if(five>0&&ten>0){
                    five--;
                    ten--;
                }else if(ten<1&&five>2){
                    five-=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
