package Test;

import java.util.PriorityQueue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/31 19:13
 * @description TODO
 **/
public class findKthLargest_ implements A{
    public int findKthLargest (int[] array, int k) {
        // write code here
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);

        for (int i : array) {
            pq.add(i);
        }
        int res=0;
        for (int i = 0; i < k; i++) {
            res=pq.poll();
        }
        return res;
    }
}
interface A{
    public int x = 0;
}