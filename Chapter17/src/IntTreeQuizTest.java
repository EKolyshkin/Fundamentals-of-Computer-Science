public class IntTreeQuizTest
{
    public static void main(String[] args809)
    {
        // Code to post with Quiz17
        // copyright Bellevue College
        IntTree tree68 = new IntTree(new IntTreeNode(9,new IntTreeNode(8),new IntTreeNode(7)));
        tree68.printSideways();
        System.out.println("---------------------------------");
        tree68.partialStutter();
        tree68.printSideways();
        System.out.println("\n------------------------\n");

        System.out.println("\n\n");
        
        IntTree tree69 = new IntTree(new IntTreeNode(9,new IntTreeNode(3, new IntTreeNode(7), null),new IntTreeNode(7, new IntTreeNode(-9), null)));
        tree69.printSideways();
        System.out.println("---------------------------------");
        tree69.partialStutter();
        tree69.printSideways();
        System.out.println("\n------------------------\n");
     }
}
