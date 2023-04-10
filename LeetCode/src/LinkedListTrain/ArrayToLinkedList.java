package LinkedListTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/4 18:21
 * @description TODO
 **/
public class ArrayToLinkedList {

    public static ListNode AsLinkedList(int[]nums){
        ListNode head=new ListNode();
        ListNode tmp=head;
        for (int i = 0; i < nums.length; i++) {
            tmp.val=nums[i];
            if(i==nums.length-1){
                return head;
            }
            tmp.next=new ListNode();
            tmp=tmp.next;
        }
        return head;
    }
}
