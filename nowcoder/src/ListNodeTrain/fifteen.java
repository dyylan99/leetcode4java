package ListNodeTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/6/3 20:55
 * @description 删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次
 * 数据范围：链表长度满足  0≤n≤100，链表中任意节点的值满足  ∣val∣≤100
 * 进阶：空间复杂度 O(1)，时间复杂度 O(n)
 **/
public class fifteen {
    public ListNode deleteDuplicates (ListNode head) {
        /**
         * 思路一:将链表中的元素存入数组中,再对数组进行操作
         */
        if(head == null||head.next==null){
            return head;
        }
        int []nodeList=new int[100];
        ListNode workNode=head;
        int length=0;
        while(workNode!=null){
            nodeList[length++]=workNode.val;
            workNode=workNode.next;
        }
        workNode=head;
        for (int i = 0; i <length -1; i++) {
           if(nodeList[i]!=nodeList[i+1]){
               workNode.next.val=nodeList[i+1];
               workNode=workNode.next;
           }

        }
        workNode.next=null;
        return head;
    }
    /**
     * 直接对链表操作
     */
    public ListNode deleteDuplicates1 (ListNode head){
        if(head == null||head.next==null){
            return head;
        }
        ListNode cur=head;
        while(cur.next!=null){
            if(cur.val==cur.next.val){
                cur.next=cur.next.next;
            }else{
                cur=cur.next;
            }
        }
        return head;
    }

}
