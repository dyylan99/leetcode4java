package Greed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/9 13:58
 * @description n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 *
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 *
 * 135. 分发糖果
 **/
public class candy_ {
    public int candy(int[] ratings) {
      int []candyList=new int[ratings.length];
        Arrays.fill(candyList,1);
        //右孩子比左孩子大的情况
        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i]>ratings[i-1]){
                candyList[i]=candyList[i-1]+1;
            }
        }
        //左孩子比右孩子大的情况
        for (int i = ratings.length-2; i >=0 ; i--) {
            if(ratings[i]>ratings[i+1]){
                candyList[i]=Math.max(candyList[i],candyList[i+1]+1);
            }
        }
        int res=0;
        for (int i : candyList) {
            res+=i;
        }
        return res;
    }
}
