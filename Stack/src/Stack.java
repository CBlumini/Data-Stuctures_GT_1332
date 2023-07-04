public class Stack <T> {

    private T[] backingArray;
    private int size;
    public static final int INITIAL_CAPACITY = 9;

    public Stack() {
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }


    public void push(T data) {
        backingArray[size++] = data;
    }

    public T pop() {
        T temp = backingArray[--size];
        backingArray[size]=null;
        return temp;
    }

    public static void main(String[] args) {
        Stack <String> foo = new Stack<>();

        foo.push("this");
        foo.push("a");
        foo.push("Stack");

        System.out.println(foo.pop());
        System.out.println(foo.pop());

    }

}
