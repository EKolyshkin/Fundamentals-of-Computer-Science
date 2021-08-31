/* Egor Kolyshkin
 * CS 211, 3/8/21
 * Chapter 17 Assignment
 * SearchTree<E> Class
 * Methods isFull(); equals(t2); removeLeaves(); remove(data)
 */

// Class SearchTree stores and prints a binary search tree of
// objects of type E.  E must implement the Comparable<E>
// interface.  from Reges and Stepp, Building Java Programs
//
// modified by W.P. Iverson, to not allow duplicates added
// added toString()
// Bellevue College, January 2021

public class SearchTree<E extends Comparable<E>>
{
    private SearchTreeNode<E> overallRoot; // root of overall tree

    // post: constructs an empty search tree
    public SearchTree()
    {
        overallRoot = null;
    }
    
    // WRITE ADDITIONAL METHODS HERE:

    /*  Write a method called isFull that returns true if a binary tree
        is full and false if it is not. A full binary tree is one in
        which every node has 0 or 2 children. For example, reference
        trees #1 and #2 are not full, but #3 is full. By definition,
        the empty tree is considered full.
    */
    public boolean isFull()
    {
        return isFull(overallRoot);
    }

    // isFull() helper
    private boolean isFull(SearchTreeNode<E> root)
    {
        if (root == null)
        {   // when node has no children
            return true;
        }
        else if (root.right != null && root.left == null)
        {   // when only right node is empty
            return false;
        }
        else if (root.left != null && root.right == null)
        {   // when only left node is empty
            return false;
        }
        else
        {   // keeps digging for both sides
            return isFull(root.left) && isFull(root.right);
        }
    }

    /*  Write a method called equals that accepts another binary tree
        of integers as a parameter and compares the two trees to see
        whether they are equal to each other. For example, if variables
        of type IntTree called t1 and t2 have been initialized, then
        t1.equals(t2) will return true if the trees are equal and false
        otherwise. Two empty trees are considered to be equal to each
        other.
    */
    public boolean equals(SearchTree<E> t2)
    {
        return equals(overallRoot, t2.overallRoot);
    }

    // equals(SearchTree) helper
    private boolean equals(SearchTreeNode<E> t1, SearchTreeNode<E> t2)
    {
        if (t1 == null && t2 == null)
        {   // if both are empty
            return true;
        }
        else if (t1.data.compareTo(t2.data) != 0)
        {   // if specific nodes are different
            return false;
        }
        else
        {   // keeps digging for both sides
            return equals(t1.left, t2.left) && equals(t1.right, t2.right);
        }
    }
    
    /*  Write a method called removeLeaves that removes the leaves from
        a tree. A leaf is a node that has empty left and right subtrees. If
        your method is called on an empty tree, the method does not change
        the tree because there are no nodes of any kind (leaf or not).
    */
    public void removeLeaves()
    {
        overallRoot = removeLeaves(overallRoot);
    }

    // removeLeaves() helper
    private SearchTreeNode<E> removeLeaves(SearchTreeNode<E> root)
    {
        if (root == null || (root.left == null && root.right == null))
        {   // if node doesn't exist or is not a leaf
            return null;
        }
        else
        {   // keeps digging through both sides
            root.left = removeLeaves(root.left);
            root.right = removeLeaves(root.right);
            return root;
        }
    }

    /*  Add a method remove to the class that removes a given data
        from the tree, if present.  Assume that the elements of the
        tree constitute a legal binary search tree, and remove
        the data in such a way as to maintain ordering.
    */
    public void remove(E data)
    {
        overallRoot = remove(overallRoot, data);
    }
    
    private SearchTreeNode<E> remove(SearchTreeNode<E> root, E data) {
        if (root == null)
        {
            return null;
        }
        else if (root.data.compareTo(data) > 0)
        {
            root.left = remove(root.left, data);
        }
        else if (root.data.compareTo(data) < 0)
        {
            root.right = remove(root.right, data);
        }
        else
        {   // root.data == data; remove this node
            if (root.right == null)
            {
                return root.left;    // no R child; replace w/ L
            }
            else if (root.left == null)
            {
                return root.right;   // no L child; replace w/ R
            }
            else
            {
                // both children; replace w/ min from R
                root.data = getMin(root.right);
                root.right = remove(root.right, root.data);
            }
        }

        return root;
    }

    // Returns the minimum value from this BST.
    // Throws a NoSuchElementException if the tree is empty.
    public E getMin()
    {
        if (overallRoot == null)
        {
            return null;
            // throw new NoSuchElementException();
        }

        return getMin(overallRoot);
    }

    private E getMin(SearchTreeNode<E> root)
    {
        if (root.left == null)
        {
            return root.data;
        }
        else
        {
            return getMin(root.left);
        }
    }

    // post: value added to tree so as to preserve binary search tree
    public void add(E value) {
        overallRoot = add(overallRoot, value);
    }

    // post: value added to tree so as to preserve binary search tree
    private SearchTreeNode<E> add(SearchTreeNode<E> root, E value)
    {
        if (root == null)
        {
            root = new SearchTreeNode<E>(value);
        }
        else if (root.data.compareTo(value) > 0)
        {
            root.left = add(root.left, value);
        }
        else if (root.data.compareTo(value) < 0)
        {
            root.right = add(root.right, value);
        }

        return root;
    }

    // post: returns true if tree contains value, returns false otherwise
    public boolean contains(E value)
    {
        return contains(overallRoot, value);
    }   

    // post: returns true if given tree contains value, returns false otherwise
    private boolean contains(SearchTreeNode<E> root, E value)
    {
        if (root == null)
        {
            return false;
        }
        else
        {
            int compare = value.compareTo(root.data);

            if (compare == 0)
            {
                return true;
            }
            else if (compare < 0)
            {
                return contains(root.left, value);
            }
            else
            {   // compare > 0
                return contains(root.right, value);
            }
        }
    }

    // post: prints the data of the tree, one per line
    public void print() {
        printInorder(overallRoot);
    }

    // post: prints the data of the tree using an inorder traversal
    private void printInorder(SearchTreeNode<E> root) {
        if (root != null) {
            printInorder(root.left);
            System.out.println(root.data);
            printInorder(root.right);
        }
    }
    
    // toString() added by W.P. Iverson for simple console testing
    // since String is immutable, I've used StringBuilder
    public String toString() {
    	StringBuilder s = new StringBuilder();
    	toString(overallRoot, 0, s);
    	return s.toString();
    }
    
    // similar reverse in order traversal of tree as print sideways
    private void toString(SearchTreeNode<E> root, int level, StringBuilder s) {
        if (root != null) {
            toString(root.right, level + 1, s);
            String temp = new String(); // different for each node
            for (int i = 0; i < level; i++) {
            	temp += "    ";
            }
            s.append(temp + root.data + "\n"); // uses same String in recursions
            toString(root.left, level + 1, s);
        }
    }

    
    
    // a private inner Class for the search tree nodes
    // there is no use for such nodes outside of the SearchTree Class
    // so a private inner Class is appropriate in this case...
    private static class SearchTreeNode<E> {
        public E data;                   // data stored in this node
        public SearchTreeNode<E> left;   // left subtree
        public SearchTreeNode<E> right;  // right subtree

        // post: constructs a leaf node with given data
        public SearchTreeNode(E data) {
            this(data, null, null);
        }

        // post: constructs a node with the given data and links
        public SearchTreeNode(E data, SearchTreeNode<E> left,
                              SearchTreeNode<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
