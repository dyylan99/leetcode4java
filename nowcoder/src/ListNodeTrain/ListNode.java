package ListNodeTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/5/30 18:57
 * @description 输入一个长度为 n 的链表，设链表中的元素的值为 ai ，返回该链表中倒数第k个节点。
 * 如果该链表长度小于k，请返回一个长度为 0 的链表。
 * 思路一:第一想到的是倒转链表,然后按k返回前几个元素
 **/
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
