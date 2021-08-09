package work8_9;

import publicUtil.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:NC14 按之字形顺序打印二叉树
 * https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0?tpId=190&&tqId=35183&rp=1&ru=/activity/oj&qru=/ta/job-code-high-rd/question-ranking
 * User: starry
 * Date: 2021 -08 -09
 * Time: 15:41
 */
public class Work1 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if(pRoot == null) return new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> out = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int count = 1;
        while(!queue.isEmpty()) {
            ArrayList<Integer> in = new ArrayList<>();
            int size = queue.size();
            while(size > 0) {
                TreeNode tmp = queue.poll();
                if(tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if(tmp.right != null) {
                    queue.offer(tmp.right);
                }
                in.add(tmp.val);
                size--;
            }
            if(count%2 == 0) {
                int left = 0;
                int right = in.size()-1;
                while(left < right) {
                    int tmp = in.get(left);
                    in.set(left,in.get(right));
                    in.set(right,tmp);
                    left++;
                    right--;
                }
            }
            out.add(in);
            count++;
        }
        return out;
    }

    public ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> out = new ArrayList<>();
        if(pRoot == null) return out;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int count = 1;
        while(!queue.isEmpty()) {
            ArrayList<Integer> in = new ArrayList<>();
            int size = queue.size();
            while(size > 0) {
                TreeNode tmp = queue.poll();
                if(tmp.left != null) queue.offer(tmp.left);
                if(tmp.right != null) queue.offer(tmp.right);
                if(count%2 == 1) in.add(tmp.val);
                else in.add(0,tmp.val);
                size--;
            }
            out.add(in);
            count++;
        }
        return out;
    }

}
