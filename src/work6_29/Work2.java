package work6_29;

/**
 * Created with IntelliJ IDEA.
 * Description:用链表实现归并排序
 * User: starry
 * Date: 2021 -06 -29
 * Time: 20:45
 */

class Node {
    public int val;
    public Node next;
    public Node() {

    }
    public Node(int val) {
        this.val = val;
    }
}

public class Work2 {

    public Node merge(Node a,Node b) {
        Node head = new Node();
        Node cur = head;
        while(a != null && b != null) {
            if(a.val <= b.val) {
                cur.next = a;
                a = a.next;
            }else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        if(a == null) {
            cur.next = b;
        }else {
            cur.next = a;
        }
        return head.next;
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;
        Node fast = head;
        Node mid = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            mid = mid.next;
        }
        Node half = mid.next;
        mid.next = null;
        Node h = mergeSort(head);
        Node f = mergeSort(half);
        return merge(h,f);
    }

    public static void main(String[] args) {
        //8,4,5,7,1,3,6,2
        Work2 a = new Work2();
        int[] arr = {8,4,5,7,1,3,6,2};
        Node head = new Node(8);
        Node stp = head;
        for (int i = 1; i < arr.length; i++) {
            Node cur = new Node(arr[i]);
            stp.next = cur;
            stp = stp.next;
        }
//        while(head != null) {
//            System.out.println(head.val);
//            head = head.next;
//        }
        Node res = a.mergeSort(head);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}
