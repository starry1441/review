package work8_10;

import publicUtil.ListNode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -08 -10
 * Time: 10:34
 */
public class Work1 {

    public ListNode addInList (ListNode head1, ListNode head2) {
        head1 = reverse(head1);
        head2 = reverse(head2);
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int add1 = 0;
        while(head1 != null || head2 != null || add1 != 0) {
            int val1 = head1 == null ? 0 : head1.val;
            int val2 = head2 == null ? 0 : head2.val;
            int val = val1 + val2 + add1;
            if(val > 9) {
                val = val%10;
                add1 = 1;
            }else {
                add1 = 0;
            }
            ListNode node = new ListNode(val);
            cur.next = node;
            cur = cur.next;
            if(head1 != null) head1 = head1.next;
            if(head2 != null) head2 = head2.next;
        }
        head = reverse(head.next);
        return head;
    }
    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = head.next;
        head.next = null;
        ListNode curNext = cur;
        while(cur != null) {
            curNext = cur.next;
            cur.next = head;
            head = cur;
            cur = curNext;
        }
        return head;
    }
    public void print(ListNode head) {
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode n9 = new ListNode(9);
        ListNode n3 = new ListNode(3);
        ListNode n7 = new ListNode(7);
        n9.next = n3;
        n3.next = n7;
        ListNode n6 = new ListNode(6);
        ListNode n33 = new ListNode(3);
        n6.next = n33;
        Work1 a = new Work1();
        ListNode head = a.addInList(n9,n6);
        a.print(head);
    }

}
