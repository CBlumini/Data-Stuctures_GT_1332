package MinHeap;

import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.MinHeap.
 * https://www.mathcs.emory.edu/~cheung/Courses/171/Syllabus/9-BinTree/heap-insert.html
 * How comparable works
 * data1.compareTo(data2)
 * If the int is positive, then data1 is larger than data2.
 * If the int is negative, then data1 is smaller than data2.
 * If the int is zero, then data1 equals data2.
 */
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap.MinHeap.
     * <p>
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new MinHeap.MinHeap.
     * <p>
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MinHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     * <p>
     * Method should run in amortized O(log n) time.
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If the data is null.
     */
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        //increment the size since we leave zero index blank
        size++;
        //if size reaches the length of the array double the length
        if (size >= backingArray.length) {
            doubleSize();
        }
        //assign the data to the last index of the heap
        backingArray[size] = data;
        //call the iterative uphead method to enforce the minheap requirements
        upHeapIt(size);
    }

    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     * <p>
     * Method should run in O(log n) time.
     *
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the heap is empty.
     */
    public T remove() {
        if (backingArray[1] == null) {
            throw new NoSuchElementException();
        }
        //store the value to be removed, so it can be returned later
        T removedThing = backingArray[1];
        //swap the last value into the removed values location
        backingArray[1] = backingArray[size];
        //decrement the size since we have now removed a value
        size--;
        //call downheap to restore order to the heap
        downHeapIt();
        //return the removed value
        return removedThing;
    }

    /**
     * Returns the backing array of the heap.
     * <p>
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     * <p>
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    //this might be better: https://instructobit.com/tutorial/107/Redefining-an-array's-values-and-size-in-Java
    private void doubleSize() {
        T[] tempArr = backingArray;
        backingArray = (T[]) new Comparable[size * 2];
        for (int i = 0; i < tempArr.length; i++) {
            backingArray[i] = tempArr[i];
        }
    }

    //not currently using this
    private void upHeapRec(int location) {
        //do this recursively
        //temp variable to use as the parent and a temp var
        int parent;
        T temp;
        parent = (location - 1) / 2;
        //the recursion
        if (backingArray[parent].compareTo(backingArray[location]) < 0) {
            temp = backingArray[parent];
            backingArray[parent] = backingArray[location];
            backingArray[location] = temp;
            upHeapRec(parent);
        }
    }

    //https://www.mathcs.emory.edu/~cheung/Courses/171/Syllabus/9-BinTree/heap-insert.html
    //need to check the compareTo if statement is correct
    private void upHeapIt(int location) {
        if (location != 1) {
            //initialize the parent
            int parent = location / 2;
            T temp;

            //could probably do this more cleanly with a "DO" loop as this appears to run an extra time
            do {

                //this comparison will return a value less than 1 if location is smaller then parent
                if (backingArray[location].compareTo(backingArray[parent]) < 0) {
                    temp = backingArray[parent];
                    backingArray[parent] = backingArray[location];
                    backingArray[location] = temp;
                    location = parent;
                    parent = location / 2;
                } else {
                    break;
                }
            } while (parent > 0);
        }
    }

    private void downHeapIt() {
        //starting index
        int location = 1;
        //create a temp to store data
        T temp;
        //will need to update location and then redo these after swap, so these are initial and we will *gasp* repeat ourselves later
        int leftChild = (2 * location);
        int rightChild = (2 * location) + 1;
        backingArray[size + 1] = null;


        //taking advantage of In a MinHeap.MinHeap containing n elements, only the first n / 2 elements will have children
        while (location <= size / 2) {

            //make sure there are two children
            if (backingArray[rightChild] == null) {
                if (backingArray[location].compareTo(backingArray[leftChild]) > 0) {
                    temp = backingArray[location];
                    backingArray[location] = backingArray[leftChild];
                    backingArray[leftChild] = temp;
                    //this helps us follow the data down the tree
                    location = leftChild;
                }
            }

            else {
                    //compare the children to see which is smaller
                    //this comparison will return a value less than 1 if left child is smaller than right child
                    if (backingArray[leftChild].compareTo(backingArray[rightChild]) < 0) {
                        //this comparison will return a value less than 1 if location is smaller than the left child
                        if (backingArray[location].compareTo(backingArray[leftChild]) > 0) {
                            temp = backingArray[location];
                            backingArray[location] = backingArray[leftChild];
                            backingArray[leftChild] = temp;
                            //this helps us follow the data down the tree
                            location = leftChild;
                        }
                        //this comparison will return a value greater than 1 if left child is larger than right child
                    } else if (backingArray[leftChild].compareTo(backingArray[rightChild]) > 0) {
                        //this comparison will return a value less than 1 if location is smaller than the right child
                        if (backingArray[location].compareTo(backingArray[rightChild]) > 0) {
                            temp = backingArray[location];
                            backingArray[location] = backingArray[rightChild];
                            backingArray[rightChild] = temp;
                            //this helps us follow the data down the tree
                            location = rightChild;
                        }
                        //nothing left to find which means we are at the end of the heap
                    } else {
                        break;
                    }
                }
                //update the children
                leftChild = (2 * location);
                rightChild = (2 * location) + 1;
            }
            //set the last point of the backing array to null

        }
        //private void initializeHeap() {
        //    backingArray[0] = 0;
        //}
    }
