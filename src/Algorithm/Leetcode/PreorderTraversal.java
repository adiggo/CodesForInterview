package Algorithm.Leetcode;

import Algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by i843719 on 12/8/14.
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        //easy one
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)   return result;
        Stack<TreeNode> preStack = new Stack<TreeNode>();
        preStack.push(root);

        while(!preStack.isEmpty()){
            TreeNode newRoot = preStack.pop();
            result.add(newRoot.val);
            if(newRoot.right != null)
                preStack.push(newRoot.right);
            if (newRoot.left != null)
                preStack.push(newRoot.left);
        }

        return result;
    }
}
