package work8_7;

import publicUtil.ListNode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -08 -07
 * Time: 18:33
 */
public class Work1 {

    public ListNode reverseKGroup (ListNode head, int k) {
        if(k <= 1) return head;
        ListNode cur = head;
        ListNode curNext = head;
        ListNode pre = head;
        ListNode newhead = head;
        ListNode b = head;
        while(cur != null) {
            int n = k;
            pre = cur;
            while(n != 0) {
                curNext = cur.next;
                if(pre == cur) {
                    newhead = pre;
                }
                cur.next = pre;
                pre = cur;
                cur = curNext;
                n--;
            }
            b = cur;
            int m = k-1;
            while(b != null && m != 0) {
                b = b.next;
                m--;
            }
            if(b == null) {
                newhead.next = cur;
                break;
            }
            newhead.next = b;
        }
        return head;
    }

    public ListNode reverseKGroup2 (ListNode head, int k) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode ret = new ListNode(0);
        ListNode p = ret;
        while(true) {
            int count = 0;
            ListNode tmp = head;
            while(tmp != null && count < k) {
                stack.push(tmp);
                tmp = tmp.next;
                count++;
            }
            if(count != k) {
                p.next = head;
                break;
            }
            while(!stack.isEmpty()) {
                p.next = stack.pop();
                p = p.next;
            }
            p.next = tmp;
            head = tmp;
        }
        return ret.next;
    }

    public static void main(String[] args) {
        //1→2→3→4→5
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        Work1 a = new Work1();
        a.reverseKGroup(n1,2);
    }

}
