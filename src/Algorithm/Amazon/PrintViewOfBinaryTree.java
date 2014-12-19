package Algorithm.Amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by i843719 on 11/22/14.
 */
public class PrintViewOfBinaryTree {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }


    public void printLeftNonRecrusive(TreeNode root){
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<TreeNode> levelList = new ArrayList<TreeNode>();
        int level = 0;
        stack.add(root);
        while(true){
            if (stack.size() == 0)
                break;
            System.out.println(stack.peek().val + "\n");
            while(!stack.isEmpty()){
                levelList.add(stack.pop());  //level list
            }
            for (int i = levelList.size() -1 ; i >= 0; i--){  //use list to get the right stack
                stack.add(levelList.get(i).right);
                stack.add(levelList.get(i).left);
            }
        }
    }


    public void recursivePrintLeft(TreeNode root){
        if (root == null)
           return;
        System.out.println(root.val);
        if (root.left != null) {
            recursivePrintLeft(root.left);
        }else if(root.right == null){
            return;
        }else if (root.right != null){
            recursivePrintLeft(root.right);
        }

    }
}
