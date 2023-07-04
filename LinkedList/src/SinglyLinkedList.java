import java.util.NoSuchElementException;

/**
 * Your implementation of a Singly-Linked List.
 */
public class SinglyLinkedList<T> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the element to the front of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        if (size == 0) { //mayber should be saying head==null ?
            head = new SinglyLinkedListNode<T>(data, head);
            tail = head;
        } else {
            //may need to play with updating the tail pointer
            //no: https://ece.uwaterloo.ca/~ece150/Lecture_materials/pdfs/5.05%20A%20linked%20list%20with%20a%20back%20pointer.pdf
            head = new SinglyLinkedListNode<T>(data, head);
        }
        size++;
    }

    /**
     * Adds the element to the back of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        SinglyLinkedListNode <T> temp = new SinglyLinkedListNode <> (data, null);
        if (head == null) {
            head = new SinglyLinkedListNode<T>(data, head);
            tail = head;
        } else {
            tail.setNext(temp);
        }
        tail = temp;
        size++;
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        SinglyLinkedListNode <T> temp = new SinglyLinkedListNode <> (head.getData(), null);
        SinglyLinkedListNode <T> tempTemp = head;
        head = head.getNext();
        tempTemp.setNext(null);
        size--;
        return (temp.getData());

    }

    /**
     * Removes and returns the last data of the list.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        SinglyLinkedListNode <T> tempTail = tail;
        SinglyLinkedListNode <T> current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        current.setNext(null);
        return tempTail.getData();
    }

    /**
     * Returns the head node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the head of the list
     */
    public SinglyLinkedListNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Returns the tail node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the tail of the list
     */
    public SinglyLinkedListNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    public static void main(String[] args) {
        SinglyLinkedList <String> foo= new SinglyLinkedList <String>();

        foo.addToFront("oa");
        foo.addToFront("0b");
        foo.addToFront("0c");
        foo.addToFront("0d");

    }


}