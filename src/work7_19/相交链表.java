package work7_19;

import publicUtil.ListNode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -07 -19
 * Time: 22:46
 */
public class 相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        int countA = 0;
        while(A != null) {
            A = A.next;
            countA++;
        }
        ListNode B = headB;
        int countB = 0;
        while(B != null) {
            B = B.next;
            countB++;
        }
        int num;
        if(countA > countB) {
            num = countA-countB;
            A = headA;
            while(num != 0) {
                A = A.next;
                num--;
            }
            B = headB;
        }else {
            num = countB-countA;
            B = headB;
            while(num != 0) {
                B = B.next;
                num--;
            }
            A = headA;
        }
        while(A != null) {
            if(A == B) {
                return A;
            }
            A = A.next;
            B = B.next;
        }
        return null;
    }

}
