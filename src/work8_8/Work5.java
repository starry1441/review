package work8_8;

import publicUtil.ListNode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -08 -08
 * Time: 17:46
 */
public class Work5 {

    public ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode fast = head;
        while(n > 0) {
            fast = fast.next;
            n--;
        }
        ListNode slow = head;
        ListNode pre = head;
        while(fast != null) {
            pre = slow;
            fast = fast.next;
            slow = slow.next;
        }
        if(slow == head) {
            head = head.next;
        }else {
            pre.next = slow.next;
        }
        return head;
    }

}
