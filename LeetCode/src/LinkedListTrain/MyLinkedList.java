package LinkedListTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/25 11:03
 * @description 设计链表的实现。您可以选择使用单链表或双链表。
 * 单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 *
 * 在链表类中实现这些功能：
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 * 707. 设计链表
 **/
public class MyLinkedList {

    int size;
    ListNode listNode;

    public MyLinkedList() {
        this.size=0;
        listNode=new ListNode(0);
    }

    public int get(int index) {
       if(index<0||index>=size){
           return -1;
       }
       ListNode currentNode=listNode;
        for (int i = 0; i <= index; i++) {
             currentNode=currentNode.next;
        }
        return currentNode.val;
    }
    //在头部添加元素
    //完成这种函数前最好完成那种通用的函数,这样就可以直接调用了,比如addAtIndex
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
       addAtIndex(size,val);
    }

    //在指定位置添加节点
    public void addAtIndex(int index, int val) {
       if(index>size){
           return;
       }
        if(index<0){
            index=0;
        }
        //让链表尺寸加一
        size++;
        //pre为添加位置的前一个节点
        ListNode pre=listNode;
        for (int i = 0; i < index; i++) {
            pre=pre.next;
        }
        ListNode toAdd=new ListNode(val);
        toAdd.next=pre.next;
        pre.next=toAdd;
    }
    //这个index指的是下标
    public void deleteAtIndex(int index) {
      if (index<0||index>=size){
          return;
      }
      size--;
      if(index==0){
          listNode=listNode.next;
          return;
      }
        ListNode pre=listNode;
        //找到删除位置的前一个节点
        for (int i = 0; i < index; i++) {
            pre=pre.next;
        }
        pre.next=pre.next.next;
    }
}
