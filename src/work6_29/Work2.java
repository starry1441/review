package work6_29;

import java.util.LinkedList;
import java.util.List;

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

    public void mergeSortInternal(Node head,Node slow,Node fast) {
        if ()
    }

    public void mergeSort(Node head) {
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        mergeSortInternal(head,slow,fast);
    }

    public static void main(String[] args) {

    }

}
