package offer2;

import HotOneHundred.ListNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/19 13:08
 * @description TODO
 **/
public class addTwoNumbers_ {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val==0){
            return l2;
        }
        if (l2.val==0){
            return l1;
        }
        //否则反转两个链表
        l1=reverse(l1);
        l2=reverse(l2);
        //正序相加
        ListNode tmp1=l1;
        ListNode tmp2=l2;
        int t=0;
        while (tmp2!=null&&tmp1!=null){
            int tmp=tmp1.val;
            tmp1.val=(tmp2.val+ tmp1.val+t)%10;
            t=(tmp+tmp2.val+t)/10;
            tmp1=tmp1.next;
            tmp2=tmp2.next;
        }
        //此时l1是我们需要求的数
        if (tmp2==null&&tmp1!=null){
            addExtra(tmp1, t);
        }else if (tmp2!=null){
            //此时l1短于l2
            //找到l1的尾结点,将tmp1插入,再进行进位
            tmp1=l1;
            while (tmp1!=null&&tmp1.next!=null){
                tmp1=tmp1.next;
            }
            //此时tmp1是l1的尾结点,连接tmp2
            tmp1.next=tmp2;
            tmp1=tmp1.next;
            addExtra(tmp1, t);
        }else{
            //两个都为null
            if (t!=0){
                tmp1=l1;
                while (tmp1.next != null){
                    tmp1=tmp1.next;
                }
                tmp1.next=new ListNode(t);
            }

        }
        ListNode node = reverse(l1);
        return node;

    }

    private void addExtra(ListNode tmp1, int t) {
        while (tmp1!=null){
            int tmp=tmp1.val;
            tmp1.val=(tmp1.val+t)%10;
            t=(tmp+t)/10;
            if (tmp1.next==null&&t!=0){
                tmp1.next=new ListNode(t);
                break;
            }
            tmp1=tmp1.next;
        }

    }

    public ListNode reverse(ListNode l){
        ListNode pre=null;
        ListNode cur=l;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }


}
