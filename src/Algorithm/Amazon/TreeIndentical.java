package Algorithm.Amazon;

/**
 * Created by i843719 on 11/21/14.
 */
public class TreeIndentical {

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public boolean isIdentical(TreeNode root1, TreeNode root2){
        if (root1 == null && root2!= null)
            return false;
        if (root1 != null && root2 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        if (!isIdentical(root1.left, root2.left) || !isIdentical(root1.right, root2.right))
            return false;
        return true;
    }
}
