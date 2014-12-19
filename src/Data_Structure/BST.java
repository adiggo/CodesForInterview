package Data_Structure;

/**
 * Created by i843719 on 11/4/14.
 */
public class BST {

    /**
     * BSTNode is a node representation for node in BST tree
     */
    private class BSTNode {
        BSTNode left, right;
        int data;

        public BSTNode(int data) {
            this.data = data;
        }
    }

    private BSTNode root;

    /**
     * Initialize BST as null
     */
    public BST() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null; ///keep record of root so that we can know whether root is null
    }

    /**
     * Public api for other use, and update root
     *
     * @param data
     */
    public void insert(int data) {
        root = insert(root, data);  // this needs to update root
    }

    /**
     * Recursion to input node and data, make use of left and right node's property.
     * left and right.
     *
     * @param node root
     * @param data The value need to be inserted
     * @return corresponding BSTNode with value of data
     */
    private BSTNode insert(BSTNode node, int data) {
        if (node == null)
            node = new BSTNode(data); // initiate the value until it is left or right of leaf
        else {
            if (data < node.data)
                node.left = insert(node.left, data); // link is built by here
            else
                node.right = insert(node.right, data);
        }
        return node;   // return the root.
    }

    /**
     * First make decision whether the tree is empty
     * If exist, search for the key,
     * if exist, use delete(root, val)
     *
     * @param k
     */
    public void delete(int k) {
        if (isEmpty())
            System.out.println("Tree is empty, no element can be found");
        else if (search(k) == false)
            System.out.println("No such element can be found in the tree");
        else {
            root = delete(root, k);
            System.out.println("element k is deleted");
        }
    }

    /**
     * This has already guaranteed that val in in the tree
     *
     * @param root
     * @param k
     * @return
     */
    private BSTNode delete(BSTNode root, int k) {
        if (root.data == k) {
            BSTNode left, right;
            left = root.left;
            right = root.right;
            if (left == null && right == null)   // since this already delete from tree, if its left and right is null, it does not influence anything
                return null;
            else if (left == null) {
                return right;
            } else if (right == null) {
                return left;
            } else {
                BSTNode oRight = right;
                while (right.left != null) {
                    right = right.left; // find minimum element in BST
                }
                right.left = left;
                right.right = deleteMin(right);
                return oRight;
            }
        }
        if (root.data < k) {
            root.right = delete(root.right, k);
        }
        if (root.data > k) {
            root.left = delete(root.left, k);
        }
        return root;
    }

    private BSTNode deleteMin(BSTNode node){
        if (node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        return node;
    }
    public boolean search(int k) {
        return search(root, k);
    }

    /**
     * Set node to left or right according to the relation between input val and node value. Do a recursion
     *
     * @param r
     * @param val
     * @return
     */
    private boolean search(BSTNode r, int val) {
        boolean found = false;
        while (r != null && !found) {
            int rval = r.data;
            if (val < rval) {
                r = r.left;
            } else if (val > rval) {
                r = r.right;
            } else {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }

}



