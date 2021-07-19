package work7_19;

import publicUtil.ListNode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -07 -19
 * Time: 22:28
 */
public class 链表的回文结构 {

    public boolean chkPalindrome(ListNode A) {
        ListNode fast = A;
        ListNode slow = A;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode cur = slow;
        ListNode curNext = slow;
        ListNode pre = slow;
        while(cur != null) {
            curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        slow.next = null;
        while(pre != null) {
            if(A.val == pre.val) {
                A = A.next;
                pre = pre.next;
            }else {
                return false;
            }
        }
        return true;
    }

}
