package work7_17;

import publicUtil.ListNode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -07 -17
 * Time: 21:07
 */
public class 反转链表 {

    //头插法
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = head.next;
        ListNode curNext = cur;
        head.next = null;
        while(cur != null) {
            curNext = cur.next;
            cur.next = head;
            head = cur;
            cur = curNext;
        }
        return head;
    }

    //改变两节点间指向关系
    public ListNode reverseList2(ListNode head) {
        if(head == null) return head;
        ListNode cur = head.next;
        ListNode pre = head;
        pre.next = null;
        ListNode curNext = null;
        while(cur != null) {
            curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        head = pre;
        return head;
    }
}

