package work7_29;

import publicUtil.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -07 -29
 * Time: 16:27
 */
public class 另一棵树的子树 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(root.val == subRoot.val) {
            if(isSame(root,subRoot)) return true;
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    public boolean isSame(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        if(root.val != subRoot.val) return false;
        return isSame(root.left,subRoot.left) && isSame(root.right,subRoot.right);
    }

}
