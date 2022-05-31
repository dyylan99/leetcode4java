package ListNodeTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/5/31 9:38
 * @description 输入两个无环的单向链表，
 * 找出它们的第一个公共结点，
 * 如果没有公共节点则返回空。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 **/
public class ten {
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        /**
         * 思路一:转置两个链表,转制后的第一个元素是否一样,
         * 若一样则说明有公共节点,然后依次往前边遍历,找到公共节点的入口,然后再进行转置
         * 若不一样则说明无公共部分
         * 此思路需要转置链表两次,不太方便
         *
         *
         * 此方法行不通,因为是链表的公共部分,所以在反转一个链表的同时,另外一个链表的结构就会被破坏
         */
        if(pHead1==null||pHead2==null){
            return null;
        }
        ListNode reHead1=reverNodes(pHead1);
        ListNode workNode1=reHead1;
        ListNode reHead2=reverNodes(pHead2);
        ListNode workNode2=reHead2;
        if(workNode1!=workNode2){
            return null;
        }
        while(workNode1!=null&&workNode2!=null){
            if(workNode1.next!=workNode2.next){
                break;
            }
            workNode1=workNode1.next;
            workNode2=workNode2.next;
        }
        pHead1=reverNodes(reHead1);
        while(true){
            if(pHead1==workNode1){
                return pHead1;
            }
            pHead1=pHead1.next;
        }


    }
    public ListNode reverNodes(ListNode head){
        ListNode preHead=new ListNode(-1);
        preHead.next=head;
        ListNode cur=head;
        ListNode next;
        while(cur!=null&&cur.next!=null){
            next=cur.next;
            cur.next=next.next;
            next.next= preHead.next;
            preHead.next=next;
        }
        return preHead.next;
    }


    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2){
        /**
         * 思路二:首先求出两个链表的长度差
         * ,然后让长的链表的指针先走两个链表的长度差,再一起走,判断两个指针是否相同
         */
        int length1=0,length2=0;
        ListNode work1=pHead1;
        ListNode work2=pHead2;
        ListNode res1=pHead1;
        ListNode res2=pHead2;
        /**
         * 第一步求长度
         */
        while(work1!=null){
            length1++;
            work1=work1.next;
        }  while(work2!=null){
            length2++;
            work2=work2.next;
        }
        /**
         * 第二步:谁长谁先走长度差步:
         */
        if(length1>length2){
            for (int i = 0; i < (length1-length2); i++) {
                res1=res1.next;
            }
            /**
             * 一起走,边走边判断:res1与res2指向的节点是否相同
             */
            while(res1!=null&&res2!=null&&res1!=res2){
                res1=res1.next;
                res2=res2.next;
            }
            return res1;
        }else{
            for (int i = 0; i < (length2-length1); i++) {
                res2=res2.next;
            }
            /**
             * 一起走,边走边判断:res1与res2指向的节点是否相同
             */
            while(res1!=null&&res2!=null&&res1!=res2){
                res1=res1.next;
                res2=res2.next;
            }
            return res1;
        }
    }

/**
 * 1链表:a+n 2链表:b+n 假设a>b ,则1走了 b+n时,2到了1链表的起点,此时1距离终点a-b,
 * 1继续走a-b,到达2链表的起点,2走了a-b,距离终点还有b+n,距离公共入口还有b
 * 而此时1距离终点也有b+n距离,距离公共入口也有b,所以接下来1与2的路程与相对路程一致
 * 时间复杂度:O(n+b+a-b+b)=o(n+a+b)
 *
 */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2){
        ListNode p1=pHead1;
        ListNode p2=pHead2;
        while(p1!=p2){
            p1=(p1==null?pHead2:p1.next);
            p2=(p2==null?pHead1:p2.next);
        }
        return p1;
    }
}
