package BST;
import BSTNode.BSTNode;

import java.util.NoSuchElementException;

/**
 * Your implementation of a BST.
 * https://stackoverflow.com/questions/13714395/adding-objects-to-bst-in-java
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the data to the tree.
     *
     * This must be done recursively.
     *
     * The new data should become a leaf in the tree.
     *
     * Traverse the tree to find the appropriate location. If the data is
     * already in the tree, then nothing should be done (the duplicate
     * shouldn't get added, and size should not be incremented).
     *
     * Should be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to add to the tree.
     * @throws java.lang.IllegalArgumentException If data is null.
     */
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        root = rAdd(data, root);
    }
    private BSTNode<T> rAdd( T toAdd, BSTNode<T> curr){
        if (curr == null){
            size++;
            return new BSTNode<>(toAdd);
        }
        else if (toAdd.compareTo(curr.getData()) < 0) {
            curr.setLeft(rAdd(toAdd, curr.getLeft()));
        }
        else if (toAdd.compareTo(curr.getData()) > 0) {
            curr.setRight(rAdd(toAdd, curr.getRight()));
        }
        return curr;
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the SUCCESSOR to
     * replace the data. You should use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove.
     * @return The data that was removed.
     * @throws java.lang.IllegalArgumentException If data is null.
     * @throws java.util.NoSuchElementException   If the data is not in the tree.
     */
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        BSTNode<T> dummy = new BSTNode<T>(null);
        root = rRemove(root, data, dummy);
        return dummy.getData();
    }
    //recursive helper 1
    private BSTNode<T> rRemove (BSTNode <T> curr, T toRemove, BSTNode<T> aDummy){
        if (curr == null) {
            throw new NoSuchElementException();
        }
        else if (toRemove.compareTo(curr.getData()) < 0) {
            curr.setLeft(rRemove(curr.getLeft(), toRemove, aDummy));
        }
        else if (toRemove.compareTo(curr.getData()) > 0) {
            curr.setRight(rRemove(curr.getRight(), toRemove, aDummy));
        }
        else {
            aDummy.setData(curr.getData());
            size--;
            if (curr.getLeft() == null && curr.getRight() == null) {
                return null;
            }
            else if (curr.getLeft() != null) {
                return curr.getLeft();
            }
            else if (curr.getRight() != null) {
                return curr.getRight();
            }
            else {
                BSTNode<T> dummy2 = new BSTNode<T>(null);
                curr.setRight(remSuccessor(curr.getRight(), dummy2));
                curr.setData(dummy2.getData());
            }
        }
        return curr;
    }
    private BSTNode<T> remSuccessor (BSTNode <T> curr1, BSTNode <T> node2) {
        if (curr1.getLeft() == null ) {
            node2.setData(curr1.getData());
            return curr1.getRight();
        }
        else {
            curr1.setLeft(remSuccessor(curr1.getLeft(), node2));
        }
        return curr1;
    }

    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

}