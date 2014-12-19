package Algorithm.Amazon;

/**
 * Created by i843719 on 11/21/14.
 */
public class ConvertGivenTreeToSumTree {

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public void convert(TreeNode root){
        if (root == null)
            return;
        
    }

    private int getCurrentNodeVal(TreeNode subroot){
        if (subroot == null)
            return 0;
        if (subroot.left == null && subroot.right == null){
            subroot.val = 0; //do it in place
            return subroot.val;
        }
        int oldVal = subroot.val;
        subroot.val = getCurrentNodeVal(subroot.left) + getCurrentNodeVal(subroot.right);  //set node
        return subroot.val + oldVal; // the value for parent node sum
    }
}
