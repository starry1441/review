package work8_11;

import publicUtil.TreeNode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -08 -11
 * Time: 21:33
 */
public class Work2 {

    int i = 0;
    public TreeNode reConstructBinaryTree(int [] pre, int [] vin) {
        if(i == pre.length && vin.length == 0) return null;
        TreeNode root = null;
        for(int j = 0; j < vin.length; j++) {
            if(pre[i] == vin[j]) {
                root = new TreeNode(pre[i]);
                i++;
                root.left = reConstructBinaryTree(pre, Arrays.copyOfRange(vin,0,j));
                root.right = reConstructBinaryTree(pre,Arrays.copyOfRange(vin,j+1,vin.length));
                break;
            }
        }
        return root;
    }

}
