package Algorithm.Facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by i843719 on 11/4/14.
 */

public class PrintAllRootToPathInTree {


    public List<List<TreeNode>> printALlPathFromRootToLeaf(TreeNode node) {
        // this is a easy question
        if (node == null)
            return null;
        List<List<TreeNode>> res = new ArrayList<List<TreeNode>>();
        getAllPath(node, res, new ArrayList<TreeNode>());
        return res;
    }

    // to solve this question, we can also store all the information in an array
    // but we need to use a level to record its level
    private void getAllPath(TreeNode node, List<List<TreeNode>> res, List<TreeNode> path) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            path.add(node);
            res.add(new ArrayList<TreeNode>(path)); //here need to new a arraylist to avoid mutable problem
            return;
        }
        path.add(node);
        getAllPath(node.left, res, path);
        path.remove(node);
        getAllPath(node.right, res, path);

    }
}
