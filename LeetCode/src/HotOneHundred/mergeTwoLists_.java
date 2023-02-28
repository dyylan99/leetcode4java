package HotOneHundred;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/28 9:48
 * @description TODO
 *
 * 21. 合并两个有序链表
 **/
public class mergeTwoLists_ {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode l1=list1;
        ListNode l2=list2;
        ListNode res=new ListNode();
        ListNode cur=res;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cur.next=new ListNode(l1.val);
                l1=l1.next;
            }else{
                cur.next=new ListNode(l2.val);
                l2=l2.next;
            }
            cur=cur.next;
        }
        if (l1!=null){
           cur.next=l1;
        }
        if(l2!=null){
           cur.next=l2;
        }
        return res.next;
    }

}
