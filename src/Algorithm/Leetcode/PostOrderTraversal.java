package Algorithm.Leetcode;

import Algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by i843719 on 12/8/14.
 */
public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<Integer>();

        if (root == null){
            return result;
        }

        Stack<TreeNode> posStack = new Stack<TreeNode>();

        posStack.push(root);
        TreeNode prev = null;

        while(!posStack.isEmpty()){
            TreeNode cur = posStack.peek();
            //downside
            if (prev == null || prev.left == cur || prev.right == cur){
                if (cur.left != null){
                    posStack.push(cur.left);
                }else if (cur.right != null){
                    posStack.push(cur.right);
                }
            }else if (cur.left == prev){
                if (cur.right != null){
                    posStack.push(cur.right);
                }
            }else{
                result.add(cur.val);
                posStack.pop();
            }
            prev = cur; // the step to iterate
        }

        return result;
    }


    public List<Integer> postOrderTraversal2(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();

        if (root == null){
            return result;
        }
        Stack<TreeNode> preStack = new Stack<TreeNode>();
        Stack<TreeNode> posStack = new Stack<TreeNode>();
        preStack.push(root);
        while(!preStack.isEmpty()){
            TreeNode tmp = preStack.pop();
            posStack.push(tmp);
            if (tmp.left != null)
                preStack.push(tmp.left);
            if (tmp.right != null)
                preStack.push(tmp.right);
        }
        while(!posStack.isEmpty()){
            result.add(posStack.pop().val);
        }
        return result;
    }
}
