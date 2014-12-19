package Algorithm.Leetcode;

import Algorithm.TreeNode;

/**
 * Created by i843719 on 12/10/14.
 */
public class BuildTreeFromPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null)
            return null;
        if (preorder.length != inorder.length)
            return null;

        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length);
    }
    private TreeNode buildTree(int[] preorder, int[] inorder, int preleft, int preright, int inleft, int inright){
        //in preorder, the most left is root
        if (preleft > preright || inleft > inright)
            return null;
        int k = 0;
        for (int i = 0; i < inorder.length; i++){
            if (inorder[i] == preorder[preleft]){
                k = i;
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[preleft]);   //this is the root
        //move forward 1 for preleft,
        root.left = buildTree(preorder, inorder, preleft+1, preleft + k - inleft, inleft, k - 1);
        root.right = buildTree(preorder, inorder, preleft + k - inleft + 1, preright, k+1, inright);

        return root;
    }
}
