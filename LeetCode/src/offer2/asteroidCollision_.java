package offer2;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/24 21:03
 * @description 剑指offerII 37小行星碰撞
 **/
public class asteroidCollision_ {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> queue=new ArrayDeque<>();
        queue.push(asteroids[0]);

        for (int i = 1; i <asteroids.length ;) {
            if (queue.isEmpty()){
                queue.addLast(asteroids[i]);
                i++;
                continue;
            }
            //boolean isSameSymbol=(queue.peekLast()<0&&asteroids[i]<0)||(queue.peekLast()>0&&asteroids[i]>0);
            //这道题目是前一个向右(大于0),后一个向左(小于0)才会碰撞
            boolean willCollision=queue.peekLast()>0&&asteroids[i]<0;
            if (!willCollision){
                queue.addLast(asteroids[i]);
                i++;
                continue;
            }
            //走到这说明会碰撞,栈不为空
            if (Math.abs(asteroids[i])<Math.abs(queue.peekLast())){
                //当前元素小于栈尾:
                i++;
                continue;
            }
            //两个元素相同
            if (Math.abs(asteroids[i])==Math.abs(queue.peekLast())){
                queue.pollLast();
                i++;
                continue;
            }
            //当前元素大于栈尾
            queue.pollLast();
        }
        if (queue.isEmpty()){
            return new int[]{};
        }else{
            int size = queue.size();
            int[]res=new int[size];
           int index=0;
            for (Integer integer : queue) {
                res[index]=integer;
                index++;
            }
            return res;
        }
    }
}
