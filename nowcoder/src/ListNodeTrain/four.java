package ListNodeTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/5/26 16:47
 * @description 输入两个长度相同的递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
 **/

/**
 * 思路:
 * 1.
 * 2.
 */

public class four {
    public  static  ListNode Merge(ListNode list1,ListNode list2) {

        ListNode res=new ListNode(0);
        ListNode work=res;
        while(list1!=null&&list2!=null){
                if (list1.val <= list2.val) {
                    work.next = list1;

                    list1 = list1.next;
                } else {
                    work.next = list2;
                    list2 = list2.next;
                }
            work = work.next;
            }
        if(list1!=null){
            work.next=list1;
        }
        if(list2!=null){
            work.next=list2;
        }
    return res.next;

    }
    //递归
    public  static ListNode  merge1(ListNode list1,ListNode list2){
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        if(list1.val<=list2.val){
            list1.next=merge1(list1.next,list2);
            return list1;
        }
        else{
            list2.next=merge1(list1,list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode merge = Merge(node1, node2);
        while (merge != null) {
            System.out.println(merge.val);
            merge=merge.next;
        }
    }
}
