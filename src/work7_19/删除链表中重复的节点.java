package work7_19;

import publicUtil.ListNode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -07 -19
 * Time: 21:58
 */
public class 删除链表中重复的节点 {

    public static ListNode deleteDuplication(ListNode pHead) {
        ListNode head = new ListNode(-1);
        ListNode cur = pHead;
        ListNode sur = head;
        while(cur != null) {
            if(cur.next != null && cur.val == cur.next.val) {
                while(cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
                continue;
            }
            sur.next = cur;
            sur = sur.next;
            cur = cur.next;
        }
        sur.next = null;
        return head.next;
    }

    public static void main(String[] args) {
        //{1,1,2,3,3,4,5,5}
        ListNode l1 = new ListNode(1);
        ListNode ll1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode ll3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode ll5 = new ListNode(5);
        l1.next = ll1;
        ll1.next = l2;
        l2.next = l3;
        l3.next = ll3;
        ll3.next = l4;
        l4.next = l5;
        l5.next = ll5;
        deleteDuplication(l1);
    }

}
