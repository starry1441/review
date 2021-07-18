package work7_17;

import publicUtil.ListNode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -07 -17
 * Time: 21:04
 */
public class 移除链表元素 {

    //一开始就把头为val的全部去掉
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        while(head != null && head.val == val) {
            head = head.next;
        }
        ListNode cur = null;
        if(head != null) cur = head.next;
        ListNode pre = head;
        while(cur != null) {
            if(cur.val == val) {
                pre.next = cur.next;
            }else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return head;
    }

    //先去掉后面的val元素，最后判断头节点
    public ListNode removeElements2(ListNode head, int val) {
        if(head == null) return null;
        ListNode cur = head;
        ListNode pre = head;
        while(cur != null) {
            if(cur.val == val) {
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        if(head.val == val) {
            head = head.next;
        }
        return head;
    }

}
