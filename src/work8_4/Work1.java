package work8_4;

import publicUtil.TreeNode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -08 -04
 * Time: 11:37
 */
public class Work1 {

    int[][] arr = null;
    int count = 0;
    public int[][] threeOrders (TreeNode root) {
        con(root);
        arr = new int[3][count];
        first(root);
        mid(root);
        last(root);
        return arr;
    }
    public void con(TreeNode root) {
        if(root == null) return;
        count++;
        con(root.left);
        con(root.right);
    }
    int i = 0;
    public void first(TreeNode root) {
        if(root == null) return;
        arr[0][i] = root.val;
        i++;
        first(root.left);
        first(root.right);
    }
    int j = 0;
    public void mid(TreeNode root) {
        if(root == null) return;
        mid(root.left);
        arr[1][j] = root.val;
        j++;
        mid(root.right);
    }
    int k = 0;
    public void last(TreeNode root) {
        if(root == null) return;
        last(root.left);
        last(root.right);
        arr[2][k] = root.val;
        k++;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right =t3;
        Work1 a = new Work1();

        System.out.println(Arrays.deepToString(a.threeOrders(t1)));
    }

}
