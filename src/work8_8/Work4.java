package work8_8;

import publicUtil.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -08 -08
 * Time: 16:52
 */
public class Work4 {

    //空间On
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = pHead;
        while(cur != null) {
            if(set.contains(cur)) {
                return cur;
            }
            set.add(cur);
            cur = cur.next;
        }
        return null;
    }

    //空间O1
    public ListNode EntryNodeOfLoop2(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        if(fast == null || fast.next == null) return null;
        fast = pHead;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

}
