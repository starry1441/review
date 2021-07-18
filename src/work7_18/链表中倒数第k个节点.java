package work7_18;

import publicUtil.ListNode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -07 -18
 * Time: 11:31
 */
public class 链表中倒数第k个节点 {

    public ListNode FindKthToTail(ListNode head, int k) {
        if(head == null) return null;
        ListNode fast = head;
        while(fast != null && k != 0) {
            fast = fast.next;
            k--;
        }
        if(fast == null && k != 0) return null;
        ListNode slow = head;
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}
