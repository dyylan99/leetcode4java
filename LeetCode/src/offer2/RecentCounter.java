package offer2;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/11 20:35
 * @description TODO
 **/
public class RecentCounter {

    ArrayDeque<Integer>queue;

    public RecentCounter() {
        queue=new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.addLast(t);
        while (!queue.isEmpty()&&queue.peekFirst()<t-3000){
            queue.remove();
        }
        return queue.size();
    }
}
