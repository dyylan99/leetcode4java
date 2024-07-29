package Test;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/23 16:44
 * @description TODO
 **/
public class xm2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        String s=sc.next();
        if (n<=1){
            System.out.println(1);
            return;
        }
        String[] split = s.split(",");
        Map<Integer, ListNode>map=new HashMap<>();
        int start=split[0].charAt(0)-'0';
        for (int i = 0; i < split.length; i++) {
            String string=split[i];
            int l=string.charAt(0)-'0';
            int r=split[i].charAt(2)-'0';
            if (!map.containsKey(l)&&!map.containsKey(r)){
                ListNode l1=new ListNode();
                l1.val=l;
                ListNode r1=new ListNode();
                r1.val=r;
                l1.next=r1;
                map.put(l,l1);
                map.put(r,r1);
            }else if(!map.containsKey(l)){
                ListNode l1=new ListNode();
                l1.val=l;
                ListNode r1 = map.get(r);
                l1.next=r1;
                map.put(l,l1);
            }else if (!map.containsKey(r)){
                ListNode l1 = map.get(l);
                ListNode r1=new ListNode();
                r1.val=r;
                l1.next=r1;
                map.put(l,l1);
                map.put(r,r1);
            }else{
                ListNode l1 = map.get(l);
                ListNode r1 = map.get(r);
                l1.next=r1;
                map.put(l,l1);
            }
        }
        ListNode fast=map.get(start);
        ListNode slow=map.get(start);
        while (fast!=null && fast.next!=null){
            if (fast==slow){
                System.out.println(0);
                return;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.println(1);



    }
}
class ListNode{
    int val;
    ListNode next;
}