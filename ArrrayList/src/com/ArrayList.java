package com;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Your implementation of an ArrayList.
 */

//https://www.vogella.com/tutorials/JavaDatastructureList/article.html


public class ArrayList<T> {
    public static void main(String[] args) {
        ArrayList<Integer> foo = new ArrayList<Integer>();
        foo.addToFront(1);
        foo.addToFront(2);
        foo.addToFront(3);
        foo.addToFront(4);
        foo.addToFront(5);
        foo.addToFront(6);
        foo.addToFront(7);
        foo.addToFront(8);
        foo.addToFront(9);
/*        foo.addToBack(1);
        foo.addToBack(2);
        foo.addToBack(3);
        foo.addToBack(4);
        foo.addToBack(5);
        foo.addToBack(6);
        foo.addToBack(7);
        foo.addToBack(8);
        foo.addToBack(9);
        foo.addToBack(10);*/
        for (int i = 0; i<=9; i++) {
        foo.removeFromBack();
        }

        foo.removeFromFront();
        foo.removeFromFront();
        foo.removeFromFront();
        foo.removeFromFront();
        foo.removeFromFront();
        foo.removeFromFront();
        foo.removeFromFront();
        //foo.addToFront(10);
        System.out.println(foo.getBackingArray());
    }

    /*
     * The initial capacity of the ArrayList.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 9;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new ArrayList.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayList() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the front of the list.
     *
     * This add may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     *
     * https://stackoverflow.com/questions/7970857/java-shifting-elements-in-an-array
     */
    public void addToFront(T data) {

        if (data == null) {
            throw new IllegalArgumentException();
        }

        if (size == backingArray.length) {
            doubleSize();
        }

        for (int i = size-1; i >= 0; i--) {
            backingArray[i+1] = backingArray[i];
        }
        backingArray[0] = data;
        size++;
    }

    /**
     * Adds the data to the back of the list.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }

        if (size == backingArray.length) {
            doubleSize();
        }
        backingArray[size++] = data;
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Do not shrink the backing array.
     *
     * This remove may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        if (backingArray[0]==null){
            throw new NoSuchElementException();
        }

        T temp = backingArray[0];
        for (int i=0; i<size; i++ ) {
            backingArray[i] = backingArray[i + 1];
        }
        backingArray[size] = null;
        size--;
        return temp;
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Do not shrink the backing array.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        if (backingArray[0]==null){
            throw new NoSuchElementException();
        }

        size--;
        T temp = backingArray[size];
        backingArray[size] = null;

        return temp;
    }

    /**
     * Returns the backing array of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
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

    //this might be better: https://instructobit.com/tutorial/107/Redefining-an-array's-values-and-size-in-Java
    private void doubleSize() {
        T[] tempArr = backingArray;
        backingArray = (T[]) new Object[size * 2];
        for(int i=0; i<tempArr.length; i++){
            backingArray[i] =tempArr[i];
        }
    }

}

//backingArray = Arrays.copyOf(backingArray, s*2);


//if (size == backingArray.length) {
//    backingArray = doubleSize(size, backingArray);
//}

        /*
        if (size == backingArray.length) {
            T[] tempArr = (T[]) new Object[size*2];
            for(int i=0; i<=backingArray.length; i++){
                tempArr[i] = backingArray[i];
            }
            backingArray = (T[]) new Object[size*2];
            for(int i=0; i<=backingArray.length; i++){
                backingArray[i] =tempArr[i];
            }
        }

         */

        /*
        if (size>1) {
            for (int i = size; i >= 0; i--) {
                backingArray[i+1] = backingArray[i];
            }
            backingArray[0] = data;
        }
        else {
            backingArray[0]=data;
        }
        size++;
        */


//        T[] tempArr = (T[]) new Object[size * 2];
//        for (int i = 0; i < backingArray.length; i++) {
//            tempArr[i] = backingArray[i];
//        }
//        backingArray = (T[]) new Object[size * 2];
//                        for(int i=0; i<backingArray.length; i++){
//      backingArray[i] =tempArr[i];
//    }