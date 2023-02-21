package LinkedListTrain;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/21 10:23
 * @description 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 *
 * 143. 重排链表
 **/
public class reorderList_ {
    //使用双向队列
    public void reorderList(ListNode head) {
        Deque<ListNode>deque=new LinkedList<>();
        ListNode cur=head.next;
        while (cur!=null){
            deque.add(cur);
            cur=cur.next;
        }
        cur=head;//回到头部
        int count=0;//计数器
        while (!deque.isEmpty()){
            if(count%2==0){
                cur.next=deque.pollLast();
            }else {
                cur.next=deque.pollFirst();
            }
            cur=cur.next;
            count++;
        }
        cur.next=null;
    }

}
