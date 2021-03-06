import structure.tree.BinarySearchTree;
import utils.TreeNode;
import structure.tree.TreeIterator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TreeTest {

    private static TreeNode root;
    private static TreeNode bigTree;

    @BeforeClass
    public static void init() {
        root = BinarySearchTree.creat(5);
        bigTree = BinarySearchTree.creat(1000);
    }

    @Test
    public void testPre() {
        System.out.print("前序遍历: ");
        TreeIterator.preOrder(root);
        System.out.println();
        System.out.print("前序遍历: ");
        TreeIterator.preOrder2(root);
    }

    @Test
    public void testIn() {
        System.out.print("中序遍历: ");
        TreeIterator.inOrder(root);
        System.out.println();
        System.out.print("中序遍历: ");
        TreeIterator.inOrder2(root);
    }

    @Test
    public void testPost() {
        System.out.print("后序遍历: ");
        TreeIterator.posOrder(root);
        System.out.println();
        System.out.print("后序遍历: ");
        TreeIterator.posOrder2(root);
    }

    @Test
    public void testInsert() {
        BinarySearchTree.insert(root, 520);
        Assert.assertTrue(BinarySearchTree.search(root, 520));
    }

    @Test
    public void testDepth() {
        System.out.println("root深度：" + BinarySearchTree.getDepth(root));
        System.out.println("bigTree深度：" + BinarySearchTree.getDepth(bigTree));
    }


}
