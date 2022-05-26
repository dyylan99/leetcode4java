package ListNodeTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/5/26 15:09
 * @description 将给出的链表中的节点每 k 个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是 k 的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 **/

/**
 * 思路:
 * 1.首先遍历链表的个数,判断个数与k的关系
 * 2.设置头结点,cur指针指向每次需要遍历的子链表的第一个节点.没遍历完k个节点其向前一步,到新的需要遍历的子联表的第一个节点
 * 3.pre指针始终指向正在返转的链表的头一个元素
 * 4.Next指针指向的是cur指针的下一个节点,且next指针和pre指针构建关系
 */
class ListNode3 {
     int val;
     ListNode3 next = null;
     ListNode3(int val,ListNode3 node){
         this.val = val;;
         this.next=node;
     }
     ListNode3(){

     }
   }
public class three {
    public static ListNode3 reverseKGroup (ListNode3 head, int k) {
        ListNode3 preHead = new ListNode3();
        preHead.val = -1;
        preHead.next = head;
        //遍历指针,用于找到第k个节点,找到就反转前面k个节点,找不到就不反转
        ListNode3 count= head;
        int t=0;
        //Next节点用于保存cur的下一个节点,被反转后它在pre节点的后面
        ListNode3 Next;
        //
        ListNode3 cur = preHead.next;
        ListNode3 pre = preHead;
           while(count!=null) {
               count = count.next;
               t++;
           }
           t=t/k;
           for(int j=0;j<t;j++){
                for (int i = 0; i < k-1; i++) {
                    Next = cur.next;
                    cur.next = Next.next;
                    Next.next = pre.next;
                    pre.next = Next;
                }
                pre=cur;
                cur=cur.next;
                }
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNodeTrain.ListNode3 node5=new ListNode3(5,null);
        ListNodeTrain.ListNode3 node4=new ListNode3(4,node5);
        ListNodeTrain.ListNode3 node3=new ListNode3(3,node4);
        ListNode3 node2=new ListNode3(2,node3);
        ListNode3 Node1=new ListNode3(1,node2);
        ListNode3 listNode3 = reverseKGroup(Node1, 2);
        while(listNode3!=null){
            System.out.println(listNode3.val);
            listNode3=listNode3.next;
        }
    }

}
