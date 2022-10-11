package OneToTwenty;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/5/8 20:28
 * @description 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

/**
 * 解题思路:
 * 此题涉及到了两条单向链表元素的相加,
 * 显而易见,两个小于10的非负整数相加的结果肯定是围绕着10这个数做文章,
 * 因此,我选用了一个整数变量t来存储两条链表元素相加的结果,将t对10取余得到的结果作为新链表的值,
 * 对10整除的值作为新链表的下一个节点的值,
 * 直到两条链表的元素都遍历完为止
 *
 */

public class two {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode target = new ListNode(-1);
         ListNode current = target;
         //进位变量t
         int t=0;
        while(l1!=null||l2!=null||t!=0) {
            if(l1!=null){
                t+=l1.val;
                l1 =l1.next;
            }
            if(l2!=null){
                t+=l2.val;
                l2 =l2.next;
            }
            current.next=new ListNode(t%10);
            t=t/10;
            current=current.next;
        }
        return target.next;
    }
    public static void main(String[] args) {
    ListNode l1=new ListNode(2);
    l1.next=new ListNode(4);
    l1.next.next=new ListNode(3);
    ListNode l2=new ListNode(5);
    l2.next=new ListNode(6);
    l2.next.next=new ListNode(4);
    ListNode L=addTwoNumbers(l1,l2);
    for(ListNode l=L;l!=null;l=l.next)
    {
        System.out.println(l.val);
    }

    }

}
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
