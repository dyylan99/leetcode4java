package Greed;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/10 13:28
 * @description 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，
 * 其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 *
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，
 * 若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。
 * 弓箭一旦被射出之后，可以无限地前进。
 *
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 *
 * 452. 用最少数量的箭引爆气球
 **/
public class findMinArrowShots_ {
    public int findMinArrowShots(int[][] points) {
        //首先按气球的起点排序
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int count=1;
        for (int i = 1; i < points.length; i++) {
            if(points[i][0]>points[i-1][1]){//气球i的起点大于气球i-1的终点
                count++;
            }else{//气球i和气球i-1挨着
                points[i][1]=Math.min(points[i][1],points[i-1][1]);
            }
        }
        return count;
    }

}
