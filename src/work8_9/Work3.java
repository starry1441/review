package work8_9;

import publicUtil.ListNode;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -08 -09
 * Time: 18:11
 */
public class Work3 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode cur1 = pHead1;
        int count1 = 0;
        while(cur1 != null) {
            cur1 = cur1.next;
            count1++;
        }
        ListNode cur2 = pHead2;
        int count2 = 0;
        while(cur2 != null) {
            cur2 = cur2.next;
            count2++;
        }
        cur1 = pHead1;
        cur2 = pHead2;
        int num = count1-count2;
        if(num > 0) {
            while(num != 0) {
                cur1 = cur1.next;
                num--;
            }
        }else {
            while(num != 0) {
                cur2 = cur2.next;
                num++;
            }
        }
        while(cur1 != null) {
            if(cur1 == cur2) {
                return cur1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }

    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)return null;
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        while(true) {
            if(cur1 == cur2) return cur1;
            cur1 = cur1.next;
            cur2 = cur2.next;
            if(cur1 == cur2) return cur1;
            if(cur1 == null) cur1 = pHead1;
            if(cur2 == null) cur2 = pHead2;
        }
    }

    public ListNode FindFirstCommonNode3(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)return null;
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        while(cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
            if(cur1 != cur2) {
                if(cur1 == null) cur1 = pHead1;
                if(cur2 == null) cur2 = pHead2;
            }
        }
        return cur1;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n6;
        n6.next = n7;
        n4.next = n5;
        n5.next = n6;
        Work3 a = new Work3();
        a.FindFirstCommonNode(n1,n4);
    }

}
