package offer;

import HotOneHundred.ListNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/15 11:38
 * @description
 *
 * 剑指 Offer 06. 从尾到头打印链表
 **/
public class reversePrint_ {
    public int[] reversePrint(ListNode head) {
        if (head==null){
            return new int[0];
        }
        ListNode tem=head;
        int len=0;
        while (tem!=null){
            tem=tem.next;
            len++;
        }
        int[]res=new int[len];
        tem=head;
        for (int i = 0; i < len; i++) {
            res[i]=tem.val;
            tem=tem.next;
        }
        //双指针法反转数组
        int left=0;
        int right=len-1;
        while (right>left){
           int num=res[left];
           res[left]=res[right];
           res[right]=num;
           left++;
           right--;
        }
        return res;
    }
}
