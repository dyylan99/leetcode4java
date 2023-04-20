package offer2;

import HotOneHundred.ListNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/19 13:55
 * @description TODO
 **/
public class reorderList_ {
    public void reorderList(ListNode head) {
        ArrayDeque<ListNode>queue=new ArrayDeque<>();
        ListNode cur=head.next;
        while (cur!=null){
            queue.add(cur);
            cur=cur.next;
        }
        cur=head;
        int index=0;
        while (!queue.isEmpty()){
            if (index%2==0){
                cur.next=queue.pollLast();
            }else{
                cur.next=queue.pollFirst();
            }
            cur=cur.next;
            index++;
        }
        cur.next=null;
    }
}
