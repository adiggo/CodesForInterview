package Algorithm.Leetcode;

import Algorithm.TreeNode;

/**
 * Created by i843719 on 12/8/14.
 */
public class BinaryTreeMaximumPathSum {
    int sum;
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        sum = root.val;
        findMax(root);
        return sum;
    }

    public int findMax(TreeNode root){

        if (root == null)
            return 0;
        int left = Math.max(findMax(root.left), 0);   //this will ensure not introduce negative number.
        int right = Math.max(findMax(root.right), 0);
        //if left is not negative, and right is not negative
        sum = Math.max(left + right + root.val, sum);  // this is a sum that for each node, each nodes top down max sum

        return root.val + Math.max(left , right);

    }
}
