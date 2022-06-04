package ListNodeTrain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/6/3 18:12
 * @description 给定一个单链表，请设定一个函数，将链表的奇数位节点和偶数位节点分别放在一起，重排后输出。
 * 注意是节点的编号而非节点的数值。
 **/
public class fourteen {


    public ListNode oddEvenList (ListNode head) {
        /**
         * 思路一:借助数组,先将链表中的值存在数组中,然后按照奇偶遍历数组,将值返回给链表
         */
        //若原先的链表节点数为0,1或2,则直接返回
        if(head==null||head.next==null||head.next.next==null){
            return head;
        }
        //此时链表节点个数大于等于3
        int length=0;
        int []nodeList=new int[100000];
        ListNode workNode=head;
        //将链表节点的值放入数组中
        while(workNode!=null){
            nodeList[length++]=workNode.val;
            workNode=workNode.next;
        }
        //按照奇偶性将数组的值返回给链表
        //现将奇数位置的值返回给链表
        workNode=head;
        for(int i=0;i<length;i=i+2){
            workNode.val=nodeList[i];
            workNode=workNode.next;
        }
        for(int i=1;i<length;i=i+2){
            workNode.val=nodeList[i];
            workNode=workNode.next;
        }
        return head;
    }
    public ListNode oddEvenList1(ListNode head){
        /**
         * 思路二:直接对链表进行操作
         */
        if(head==null||head.next==null||head.next.next==null){
            return head;
        }
        ListNode workNode=head;
        ListNode evenNode=head.next;
        ListNode even=head.next;
        while(even!=null&&even.next!=null){
            workNode.next=even.next;
            workNode=workNode.next;
            even.next=workNode.next;
            even=even.next;
        }
        workNode.next=evenNode;
        return head;
    }
}
