package ListNodeTrain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/6/2 11:48
 * @description 给定一个链表，请判断该链表是否为回文结构。
 * 回文是指该字符串正序逆序完全一致。
 **/
public class thirteen {

    public boolean isPail (ListNode head) {
        /**
         * 思路一:将找到中间节点,将链表分为两半,再将其中的一段倒序,判断链表节点的值是否相等
         */
        if(head==null){
            return false;
        }
        if(head.next==null){
            return true;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        fast=slow.next;
        /**
         * 对right进行反转
         */

        while(fast!=null&&fast.next!=null){
            ListNode next=fast.next;
            fast.next=next.next;
            next.next=slow.next;
            slow.next=next;
        }
        fast=slow.next;
        slow=head;
        while(fast!=null){
            if(fast.val!=slow.val){
                return false;
            }else{
                fast=fast.next;
                slow=slow.next;
            }
        }
        return true;
    }
    /**
     * 思路二:将数值存放在数组中,直接用数组判断
     */
    public boolean isPail1 (ListNode head){
        if(head==null){
            return false;
        }
        if(head.next==null){
            return true;
        }
        List<Integer> list=new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        for(int i=0,j=list.size()-1;i<j;i++,j--){
            if(!list.get(i).equals(list.get(j))){
                return false;
            }
        }
        return true;
    }
    /**
     * 对思路二的改进:使用原始数组
     */
    public boolean isPail2 (ListNode head){
        if(head==null){
            return false;
        }
        if(head.next==null){
            return true;
        }
        int[] list=new int[100000];
        int length=0;
        while(head!=null){
            list[length++]=head.val;
            head=head.next;
        }
        for(int i=0,j=length-1;i<j;i++,j--){
            if(list[i]!=list[j]){
                return false;
            }
        }
        return true;
    }
}
