package work8_8;

import publicUtil.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -08 -08
 * Time: 22:52
 */
public class Work6 {

    TreeNode pre = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        con(pRootOfTree);
        while(pRootOfTree.left != null) {
            pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;
    }
    public void con(TreeNode cur) {
        if(cur == null) return;
        con(cur.left);
        if(pre != null) {
            cur.left = pre;
            pre.right = cur;
        }
        pre = cur;
        con(cur.right);
    }

    TreeNode root = null;
    TreeNode pre2 = null;
    public TreeNode Convert2(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        Convert(pRootOfTree.left);
        if(root == null) root = pRootOfTree;
        if(pre2 != null) {
            pRootOfTree.left = pre2;
            pre.right = pRootOfTree;
        }
        pre2 = pRootOfTree;
        Convert(pRootOfTree.right);
        return root;
    }

}
