package ListNodeTrain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/5/30 17:50
 * @description 给一个长度为n链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null。
 *
 * 数据范围：n≤10000，1<=结点值<=10000
 * 要求：空间复杂度 O(1)，时间复杂度 O(n)
 *
 * //思路:若先判断是否有环再找入口节点则时间复杂度过高
 * //思路:应该在找入口节点的同时判断是否有环,若能找到入口节点,则说明有环,入口节点为链表的末尾节点的下一个指针指向的的节点.否则返回null
 * //思路:
 **/

public class seven {
    /**
     *思路一:用数组存放链表中的节点,遍历链表的同时检查next指针指向节点的下标,当第一次遍历到已在数组中的节点时,返回节点.
     * 若直到遍历完链表还没发现已经在数组中的元素,则退出返回null
     *
     * 此方法很简单,但是用到了java的库,空间复杂度并不为1;
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        List<ListNode> nodelist=new ArrayList<>();
        while(pHead!=null){
            if(!nodelist.contains(pHead)){
                nodelist.add(pHead);
                pHead=pHead.next;
            }else{
                return pHead;
            }
        }
        return null;
    }
    /**
     * 思路二:相遇点到环入口的距离加上(环的长度×绕圈次数-1)=起点到环入口的距离
     * a为起点到入口的距离,b为入口到第一次相遇的距离,c为第一次相遇的节点到入口的距离,则有:
     * 2*(a+b)=a+(b+c)*n+b=>
     * a=(b+c)*(n-1)+c
     */
    public ListNode EntryNodeOfLoop1(ListNode pHead){
        boolean loop=false;
        ListNode low=pHead;
        ListNode fast=pHead;
        while(low!=null&&fast.next!=null&&fast.next.next!=null){
            low=low.next;
            fast=fast.next.next;
            if(low==fast){
                loop=true;
                break;
            }
        }
        if(loop){
            low=pHead;
            while(low!=fast){
                low=low.next;
                fast=fast.next;
            }
            return low;
        }
        return null;
    }


}
