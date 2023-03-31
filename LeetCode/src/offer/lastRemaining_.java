package offer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/29 16:15
 * @description 剑指 Offer 62. 圆圈中最后剩下的数字
 **/
public class lastRemaining_ {
    public int lastRemaining(int n, int m) {
        //O(n)超时
        Queue<Integer>queue=new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            queue.add(i);
        }
        int count=1;
        while (queue.size()>1){
            if(count%m!=0){
                //前m个数不出圈
                queue.add(queue.remove());
            }else{
                queue.remove();
            }
            count++;
        }
        return queue.peek();
        //         int ans = 0;
        //        // 最后一轮剩下2个人，所以从2开始反推
        //        for (int i = 2; i <= n; i++) {
        //            ans = (ans + m) % i;
        //        }
        //        return ans;
    }
}
