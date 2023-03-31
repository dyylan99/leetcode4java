package offer;

import java.beans.beancontext.BeanContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/28 15:08
 * @description 剑指 Offer 57 - II. 和为s的连续正数序列
 **/
public class findContinuousSequence_ {
    public int[][] findContinuousSequence(int target) {
        /**
         * 滑动窗口
         */
        if(target==1){
            return new int[][]{};
        }
        List<int[]>list=new ArrayList<>();

        for(int l=1,r=1,sum=0;r<target;r++){
            sum+=r;
            while(sum>target){
                sum-=l++;
            }
            if(sum==target){
                int[]tmp=new int[r-l+1];
                for(int i=0;i<tmp.length;i++){
                    tmp[i]=l+i;
                }
                list.add(tmp);
            }
        }
        int[][]res=new int[list.size()][];
        for(int i=0;i<res.length;i++){
            res[i]=list.get(i);
        }
        return res;

    }
}
