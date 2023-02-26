package HotOneHundred;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/26 11:15
 * @description TODO
 *
 * 2
 **/
public class addTwoNumbers_ {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int t=0;
        ListNode h1=l1;
        ListNode h2=l2;
        ListNode res=new ListNode();
        ListNode tem=res;
        while (h1!=null&&h2!=null){
            tem.next=new ListNode((h1.val+ h2.val+t)%10);
            t=(h1.val+h2.val+t)/10;
            h1=h1.next;
            h2=h2.next;
            tem=tem.next;
        }
        //h1没遍历完
        while (h1!=null){
            tem.next=new ListNode((h1.val+t)%10);
            t=(h1.val+t)/10;
            tem=tem.next;
            h1=h1.next;
        }
        while (h2!=null){
            tem.next=new ListNode((h2.val+t)%10);
            t=(h2.val+t)/10;
            tem=tem.next;
            h2=h2.next;
        }
        if(t!=0){
            tem.next=new ListNode(t);
        }
        return res.next;
    }
}
