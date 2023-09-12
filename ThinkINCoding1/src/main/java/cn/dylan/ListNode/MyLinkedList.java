package cn.dylan.ListNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/8/26 15:35
 * @description 707. 设计链表
 **/
public class MyLinkedList {

    int size;
    //头结点,起辅助作用, 不在实际链表的范围内
    ListNode node;

    public MyLinkedList() {
        this.size=0;
        this.node=new ListNode(0);
    }

    //public static void main(String[] args) {
    //    MyLinkedList ml=new MyLinkedList();
    //    ml.addAtHead(1);
    //    ml.addAtTail(3);
    //    ml.addAtIndex(1,2);
    //    ml.get(1);
    //    ml.deleteAtIndex(1);
    //    ml.get(1);
    //}
    /**
     * int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1
     */
    public int get(int index){
        if (index<0 || index>=size){
            return -1;
        }
        ListNode cur=node;
        for (int i = 0; i <=index; i++) {
            cur=cur.next;
        }
        return cur.val;
    }
    /**
     * void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
     */
    public void addAtHead(int val){
        addAtIndex(0,val);
    }
    /**+
     * void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。
     * 如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中
     */
    public void addAtIndex(int index, int val){
        if (index>size){
            return;
        }
        if (index<0){
            index=0;
        }
        size++;
        //该位置的前一个节点
        ListNode pre=node;
        for (int i = 0; i < index; i++) {
            pre=pre.next;
        }
        ListNode toAdd=new ListNode(val);
        toAdd.next=pre.next;
        pre.next=toAdd;
    }
    /**
     * void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
     */
    public void addAtTail(int val){
        addAtIndex(size,val);
    }

    /**
     * void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
     */
    public void deleteAtIndex(int index){
        if (index<0 || index>=size){
            return;
        }
        size--;
        //若删除的位置是首节点, 那么将原本首节点作为头结点
        if(index==0){
            node=node.next;
            return;
        }
        ListNode pre=node;
        for (int i = 0; i < index; i++) {
            pre=pre.next;
        }
        pre.next=pre.next.next;
    }



}

class ListNode{
    int val;
    ListNode next;
    public ListNode(){
    }
    public ListNode(int val){
        this.val=val;
    }
    public ListNode(int val, ListNode next){
        this.val=val;
        this.next=next;
    }
}
