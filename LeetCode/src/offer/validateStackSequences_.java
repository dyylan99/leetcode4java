package offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/20 13:06
 * @description 剑指 Offer 31. 栈的压入、弹出序列
 **/
public class validateStackSequences_ {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer>stack=new ArrayDeque<>();

        int j=0;
        for (int i : pushed) {
            stack.push(i);
            while (j<popped.length&&!stack.isEmpty()&&stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }
        return j==popped.length;
    }
}
