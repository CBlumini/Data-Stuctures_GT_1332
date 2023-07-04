import java.util.NoSuchElementException;

public class ArrayQueue<T> {


    /*
     * The initial capacity of the ArrayQueue.
     *
     * DO NOT MODIFY THIS VARIABLE.
     */
    public static final int INITIAL_CAPACITY = 9;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int front;
    private int size;

    /**
     * This is the constructor that constructs a new ArrayQueue.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayQueue() {
        // DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the back of the queue.
     *
     * If sufficient space is not available in the backing array, resize it to
     * double the current length. When resizing, copy elements to the
     * beginning of the new array and reset front to 0.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the queue
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void enqueue(T data) {
        //check if data is null
        if (data == null){
            throw new IllegalArgumentException();
        }
        //check that the array is not full, make it bigger if so
        if (size == backingArray.length) {
            doubleSize();
        }
        //insert that data
        backingArray[(front + size) % backingArray.length] = data;
        //increase the size of the array
        size++;
    }

    /**
     * Removes and returns the data from the front of the queue.
     *
     * Do not shrink the backing array.
     *
     * Replace any spots that you dequeue from with null.
     *
     * If the queue becomes empty as a result of this call, do not reset
     * front to 0.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    public T dequeue() {
        //check that there is data in the array to pull
        if (size == 0){
            throw new NoSuchElementException();
        }
        //get the value to return
        T dequeueData = backingArray[front];
        //set the index to null to remove it
        backingArray[front] = null;
        //implements the wraparound logic
        if (front == backingArray.length-1) { front = 0; }
        //shift the front down the array
        front++;
        size--;


        return dequeueData;
    }

    /**
     * Returns the backing array of the queue.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the queue
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the queue.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the queue
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    //this might be better: https://instructobit.com/tutorial/107/Redefining-an-array's-values-and-size-in-Java
    private void doubleSize() {
        //store the original array
        T[] tempArr = backingArray;
        int indexKeeper =0;
        //create a new backing array twice the size
        backingArray = (T[]) new Object[size * 2];
        //loop from fornt tracker to the end
        for (int i=front; i<tempArr.length; i++) {
            backingArray[i-front] = tempArr[i];
            indexKeeper++;
        }
        //go from zero to front to get the rest of the array
        for (int i=0; i<front; i++ ) {
            backingArray[i+indexKeeper] = tempArr[i];
        }
        front = 0;
    }
    public static void main(String[] args){
        ArrayQueue<String> foo = new ArrayQueue<String>();
        foo.enqueue("a");
        foo.enqueue("b");
        foo.enqueue("c");
        System.out.println(foo.dequeue());
        foo.enqueue("d");
        foo.enqueue("e");
        foo.enqueue("f");
        System.out.println(foo.dequeue());
        System.out.println(foo.dequeue());
        System.out.println(foo.dequeue());
        System.out.println(foo.dequeue());
        System.out.println(foo.dequeue());
        System.out.println(foo.dequeue());
        //foo.enqueue("g");
        //foo.enqueue("h");
        //foo.enqueue("i");
        //foo.enqueue("j");
        //foo.enqueue("k");
        //foo.enqueue("l");
        //foo.enqueue("m");
    }

}
