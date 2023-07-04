import TreeTraversal.TreeTraversal;
import TreeNode.TreeNode;
import java.util.List;

class Driver {
        public static void main(String[] args) {
                TreeNode<Integer> tree1 = new TreeNode<>(1);
                TreeNode<Integer> tree2 = new TreeNode<>(2);
                TreeNode<Integer> tree3 = new TreeNode<>(3);
                TreeNode<Integer> tree4 = new TreeNode<>(4);
                TreeNode<Integer> tree5 = new TreeNode<>(5);

                tree1.setLeft(tree2);
                tree2.setLeft(tree4);
                tree2.setRight(tree5);
                tree1.setRight(tree3);

                TreeTraversal result = new TreeTraversal();

                //List output = result.preorder(tree1);
                List output = result.inorder(tree1);


        }
}