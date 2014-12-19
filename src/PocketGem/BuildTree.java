package PocketGem;

import Algorithm.TreeNode;

import java.util.Stack;

/**
 * Created by i843719 on 12/11/14.
 */
public class BuildTree {
    public TreeNode construct(String s){
        if (s.length() == 0)    return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode root = new TreeNode(s.charAt(0) - '0');
        stack.push(root);
        int i = 1;
        while(i < s.length() && !stack.isEmpty()){
            TreeNode cur = null;
            if (s.charAt(i) == '?'){
                cur = new TreeNode(s.charAt(++i));
                TreeNode parent = stack.peek();
                parent.left = cur;
                stack.push(cur);
            }else if (s.charAt(i) == ':'){
                cur = new TreeNode(s.charAt(++i));
                stack.pop();
                TreeNode parent = stack.peek();
                parent.right = cur;
            }
            i++;
        }
        return root;
    }
}
