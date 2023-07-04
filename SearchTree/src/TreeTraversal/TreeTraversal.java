package TreeTraversal;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import TreeNode.TreeNode;


/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 * https://favtutor.com/blogs/tree-traversal-python-with-recursion
 */
public class TreeTraversal<T extends Comparable<? super T>> {

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */
    //TreeNode<T> base;
    //Traversals() {
    //    base=null;
    //}

    /**
     * Given the root of a binary search tree, generate a
     * pre-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the pre-order traversal of the tree.
     */
    public List<T> preorder(TreeNode<T> root) {

        return traversePreRecursive(root);

        }

    private List traversePreRecursive(TreeNode<T> node) {
        if (node == null) return new ArrayList();

        List nodeValues = new ArrayList();
        nodeValues.add(node.getData());
        nodeValues.addAll(traversePreRecursive(node.getLeft()));
        nodeValues.addAll(traversePreRecursive(node.getRight()));

        return nodeValues;
    }

    /**
     * Given the root of a binary search tree, generate an
     * in-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the in-order traversal of the tree.
     */
    public List<T> inorder(TreeNode<T> root) {
        List nodeVals = new ArrayList();
        traverseInRecursive(root, nodeVals);
        return nodeVals;
    }
    private List traverseInRecursive(TreeNode<T> node, List nodeValues) {
        if (node == null) return null;

        traverseInRecursive(node.getLeft(), nodeValues);
        nodeValues.add(node.getData());
        traverseInRecursive(node.getRight(), nodeValues);


        return nodeValues;
    }

    /**
     * Given the root of a binary search tree, generate a
     * post-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the post-order traversal of the tree.
     */
    public List<T> postorder(TreeNode<T> root) {
        List nodeVals = new ArrayList();
        traversePostRecursive(root, nodeVals);
        return nodeVals;
    }
    private List traversePostRecursive(TreeNode<T> node, List nodeValues) {
        if (node == null) return null;

        traversePostRecursive(node.getLeft(), nodeValues);
        traversePostRecursive(node.getRight(), nodeValues);
        nodeValues.add(node.getData());

        return nodeValues;
    }
}