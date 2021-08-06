package work8_6;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:设计LRU缓存结构
 * https://www.nowcoder.com/practice/e3769a5f49894d49b871c09cadd13a61?tpId=190&&tqId=35214&rp=1&ru=/activity/oj&qru=/ta/job-code-high-rd/question-ranking
 * User: starry
 * Date: 2021 -08 -06
 * Time: 23:34
 */
public class Work2 {

    static class Node {
        int key;
        int val;
        Node pre;
        Node next;
        public Node(int key,int val) {
            this.key = key;
            this.val = val;
        }
    }
    private Map<Integer,Node> map = new HashMap<>();
    private Node head = new Node(-1,-1);
    private Node tail = new Node(-1,-1);
    private int k;
    public int[] LRU (int[][] operators, int k) {
        this.k = k;
        head.next = tail;
        tail.pre = head;
        int len = 0;
        for(int i = 0; i < operators.length; i++) {
            if(operators[i].length == 2) {
                len++;
            }
        }
        int[] res = new int[len];
        int j = 0;
        for(int i = 0; i < operators.length; i++) {
            if(operators[i][0] == 1) {
                set(operators[i][1],operators[i][2]);
            }else {
                res[j] = get(operators[i][1]);
                j++;
            }
        }
        return res;
    }
    public void set(int key,int val) {
        if(map.containsKey(key)) {
            map.get(key).val = val;
        }else {
            if(map.size() == k) {
                int deleteNodeKey = tail.pre.key;
                tail.pre.pre.next = tail;
                tail.pre = tail.pre.pre;
                map.remove(deleteNodeKey);
            }
            Node node = new Node(key,val);
            map.put(key,node);
            moveToHead(node);
        }
    }
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;
            moveToHead(node);
            return node.val;
        }
        return -1;
    }
    public void moveToHead(Node node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

}
