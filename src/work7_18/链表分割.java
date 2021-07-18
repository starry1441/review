package work7_18;

import publicUtil.ListNode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -07 -18
 * Time: 13:23
 */
public class 链表分割 {

    public ListNode partition(ListNode pHead, int x) {
        ListNode cur = pHead;
        ListNode headA = new ListNode(0);
        ListNode headB = new ListNode(0);
        ListNode a = headA;
        ListNode b = headB;
        while(cur != null) {
            if(cur.val < x) {
                a.next = cur;
                a = a.next;
            }else {
                b.next = cur;
                b = b.next;
            }
            cur = cur.next;
        }
        a.next = headB.next;
        b.next = null;
        return headA.next;
    }

}
