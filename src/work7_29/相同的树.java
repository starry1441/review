package work7_29;

import publicUtil.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -07 -29
 * Time: 15:29
 */
public class 相同的树 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) {
            return false;
        }
        if(p.val!=q.val) {
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

}
