/* Egor Kolyshkin
 * CS 211, 3/10/21
 * Chapter 17 Quiz
 * IntTree Class
 */

// Simple binary tree class that includes methods to construct a
// tree of ints, to print the structure, and to print the data
// using a pre-order, in-order or post-order traversal.  The trees
// built have nodes numbered starting with 1 and numbered
// sequentially level by level with no gaps in the tree.  The
// documentation refers to these as "sequential trees."
//
// from buildingjavaprograms.com
// fixed in, post, pre, comments below
// added toString()
// by W.P. Iverson, Bellevue College, January 2021

public class IntTree {
    private IntTreeNode overallRoot;

    // pre : max > 0
    // post: constructs a sequential tree with given number of
    //       nodes
    public IntTree(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("max: " + max);
        }
        overallRoot = buildTree(1, max);
    }
    
    public IntTree() {
        overallRoot = null;
    }
    
    // constructor added so we can build page 1029 reference trees
    public IntTree(IntTreeNode given) {
        overallRoot = given;
    }

    // ADD METHODS here for exercises:
    /* Write similar methods in IntTree.java for additional Exercises,
    starting with 4-8 which specifically use the RefTree2 built above,
    continue on with suggested Exercises 9, 12, 13, 16-18.
    */
    
    /*  A. partialStutter(); a public non-recursive method that changes
        this tree to add stutter nodes (one Node with same data) on the
        right when possible, otherwise add a stutter node on the left,
        but if both left and right are not null then the node cannot be
        stuttered (thus called partial stutter).  The null node is not
        changed.  See example with tree68 below.

        B. partialStutter(IntTreeNode root); a private recursive method
        helper, returns an IntTreeNode, that does the tree traversal and
        modification for public partialStutter();
    */

    public void partialStutter()
    {
        partialStutter(overallRoot);
    }

    private void partialStutter(IntTreeNode root)
    {
        if (root == null || (root.left == null && root.right == null))
        {
            return;
        }
        if (root.left == null && root.right != null)
        {   // if left is empty and right has data
            root.left = new IntTreeNode(root.right.data);
        }
        if (root.right == null && root.left != null)
        {   // if right is empty and left has data
            root.right = new IntTreeNode(root.left.data);
        }
        else
        {   // keeps digging in both directions
            partialStutter(root.left);
            partialStutter(root.right);
        }
    }

    // public int countEvenBranches()
    // {
    //     return countEvenBranches(overallRoot);
    // }
    
    // // helper
    // private int countEvenBranches(IntTreeNode root)
    // {
    //     if (root == null || (root.left == null && root.right == null))
    //     {
    //         return 0;
    //     }
    //     else if (root.data % 2 == 0)
    //     {   // if root has children and is even
    //         return 1 + countEvenBranches(root.left) + countEvenBranches(root.right);
    //     }
    //     else
    //     {
    //         return countEvenBranches(root.left) + countEvenBranches(root.right);
    //     }
    // }

    // public void printLevel(int n)
    // {
    //     printLevel(overallRoot, n);
    // } 

    // // helper (overallRoot == level 1)
    // private void printLevel(IntTreeNode root, int n)
    // {
    //     if (root == null)
    //     {
    //         return;
    //     }
    //     else if (n == 1)
    //     {
    //         System.out.println(root.data);
    //     }
    //     else
    //     {
    //         printLevel(root.left, n - 1);
    //         printLevel(root.right, n - 1);
    //     }
    // }

    // public IntTree copy()
    // {
    //     return copy(new IntTree().overallRoot);
    // }

    // // helper
    // private IntTree copy(IntTreeNode root)
    // {
        
    // }

    // post: returns a sequential tree with n as its root unless
    // n is greater than max, in which case it returns an empty tree
    private IntTreeNode buildTree(int n, int max) {
        if (n > max) {
            return null;
        } else {
            return new IntTreeNode(n, buildTree(2 * n, max),
                                   buildTree(2 * n + 1, max));
        }
    }

    // post: prints the tree contents using a preorder traversal
    public void printPreorder() {
        System.out.print("preorder:");
        printPreorder(overallRoot);
        System.out.println();
    }

    // post: prints the tree contents using a preorder traversal
    // post: prints in preorder the tree with given root
    private void printPreorder(IntTreeNode root) {
        if (root != null) {
            System.out.print(" " + root.data);
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    // post: prints the tree contents using a inorder traversal
    public void printInorder() {
        System.out.print("inorder:");
        printInorder(overallRoot);
        System.out.println();
    }

    // post: prints in inorder the tree with given root
    private void printInorder(IntTreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(" " + root.data);
            printInorder(root.right);
        }
    }

    // post: prints the tree contents using a postorder traversal
    public void printPostorder() {
        System.out.print("postorder:");
        printPostorder(overallRoot);
        System.out.println();
    }

    // post: prints in postorder the tree with given root
    private void printPostorder(IntTreeNode root) {
        if (root != null) {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(" " + root.data);
        }
    }

    // post: prints the tree contents, one per line, following an
    //       inorder traversal and using indentation to indicate
    //       node depth; prints right to left so that it looks
    //       correct when the output is rotated.
    public void printSideways() {
        printSideways(overallRoot, 0);
    }

    // post: prints in reversed inorder the tree with given
    //       root, indenting each line to the given level
    private void printSideways(IntTreeNode root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
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
    private void toString(IntTreeNode root, int level, StringBuilder s) {
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
}