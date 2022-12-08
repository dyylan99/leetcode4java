package Greed;

import org.junit.Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/8 11:38
 * @description 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 *
 * 134. 加油站
 **/
public class canCompleteCircuit_ {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0,preCount=0;
        int curCount=0;
        for (int i = 0; i < gas.length; i++) {
            curCount+=gas[i]-cost[i];
            if(curCount<0){
                preCount+=curCount;
                curCount=0;
                start=i+1;
            }
        }
        if(curCount+preCount>=0){
            return start;
        }
        return -1;
    }



    //超时
    public boolean reach(int[]gas,int[]cost,int start,int length){
        int gasVolume=gas[start];
        int road=0;
        while (road<length){
            if(gasVolume<cost[start]){
                return false;
            }
            gasVolume-=cost[start];
            if(start==length-1){
                start=0;
            }else{
                start++;
            }
            road++;
            gasVolume+=gas[start];
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }
}
