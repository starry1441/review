package work7_12;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -07 -12
 * Time: 10:11
 */
public class Test1 {


    static class Node {
        public int key;
        public int val;
        public Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node[] array;
    public int usedSize;

    public Test1() {
        this.array = new Node[8];
    }

    public void push(int key,int val) {
        Node node = new Node(key,val);
        int index = key % array.length;

        Node cur = array[index];
        Node pre = cur;
        while (cur != null) {
            if(cur.key == key) {
                cur.val = val;
                return;
            }
            pre = cur;
            cur = cur.next;
        }
//        node.next = array[index];
//        array[index] = node;

        //尾插
        if(pre == null) {
            array[index] = node;
        }else {
            pre.next = node;
        }
        this.usedSize++;

        //负载因子调整
        if (loadFactor() >= 0.75) {
            resize();
        }
    }

    /**
     * 求负载因子
     * @return
     */
    public double loadFactor() {
        return this.usedSize*1.0 / this.array.length;
    }

    /**
     * 超过了负载因子，我们需要进行扩容
     */
    public void resize() {
        Node[] newArray = new Node[2*array.length];
        //遍历原来的数组，把原来数组里面的每个元素都进行重新哈希
        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            while (cur != null) {
                int index = cur.key % newArray.length;
                Node curNext = cur.next;
//                cur.next = newArray[index];
//                newArray[index] = cur;
//                cur = curNext;
                //尾插
                Node ind = newArray[index];
                if(ind == null) {
                    newArray[index] = cur;
                }else {
                    Node pre = ind;
                    while (ind != null) {
                        pre = ind;
                        ind = ind.next;
                    }
                    pre.next = cur;
                }
                cur.next = null;
                cur = curNext;
            }
        }
        //原来数组当中的数据 全部哈希到了 新的数组当中
        array = newArray;
    }

    public int get(int key) {
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null) {
            if(cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }

    public static void main(String[] args) {
        Test1 hashBuck = new Test1();
        hashBuck.push(1,1);
        hashBuck.push(2,2);
        hashBuck.push(10,10);
        hashBuck.push(4,4);
        hashBuck.push(5,5);
        hashBuck.push(6,6);
        hashBuck.push(7,7);
        System.out.println(hashBuck.get(6));
    }

}
