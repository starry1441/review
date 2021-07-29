package work7_29;

import publicUtil.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -07 -29
 * Time: 16:59
 */
public class 二叉树的层序遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        if(root == null) return out;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size() != 0) {
            List<Integer> in = new ArrayList<>();
            int len = queue.size();
            while(len > 0) {
                TreeNode node = queue.poll();
                in.add(node.val);
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
                len--;
            }
            out.add(in);
        }
        return out;
    }

}
