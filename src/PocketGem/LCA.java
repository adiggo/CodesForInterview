package PocketGem;

/**
 * Created by i843719 on 12/3/14.
 */
public class LCA {
    private class Node{
        Node left, right;
    }
    public Node LCA(Node root, Node p, Node q){
        if (root == null)
            return null;
        if (root == p || root == q)
            return root;
        Node L = LCA(root.left, p, q);
        Node R = LCA(root.right, p, q);
        if (L != null && R != null)
            return root;
        return L!= null? L : R;
    }
}