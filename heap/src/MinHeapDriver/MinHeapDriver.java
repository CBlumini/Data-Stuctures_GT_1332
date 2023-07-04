package MinHeapDriver;
import MinHeap.MinHeap;

public class MinHeapDriver {
    public static void main(String[] args) {
       MinHeap <Integer> testHeap = new MinHeap<Integer>();

        //for (int i = 2; i < 15; i++) {
        //    testHeap.add(i);
        //}

       testHeap.add(0);
       testHeap.add(7);
       testHeap.add(14);
       testHeap.add(28);
       testHeap.add(21);
       testHeap.add(35);
       testHeap.add(49);
       testHeap.add(42);
       testHeap.add(56);
       testHeap.add(63);
       testHeap.add(70);
       testHeap.remove();

    }
}
