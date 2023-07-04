public class SinglyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;


    /**
     * This creates nodes to be used in the SLL class
     * @param <T> data data stored in the node
     * @param <T> pointer to the next node (is the next node in the list)
     */
    private static class Node<T> {
        //variables
        private T data;
        private Node<T> next;

        //Constructor
        private Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        //default constructor
        private Node(T data) {
            this(data, null);
        }
    }

    /**
     * Add to front of the singly linked list
     * @param  data data to be added to the node
     */
    public void addToFront(T data) {
        head = new Node<T>(data, head);
        if (size==0){
            tail = head;
        }
        //newNode.next = head;
        //head = newNode;
        size++;
    }

    public void addToBack(T data) {
        //create a new node
        Node<T> newNode = new Node<>(data);
        //newNode will be added after tail such that tail's next will point to newNode
        tail.next = newNode;
        //newNode will become new tail of the list
        tail = newNode;


        //tail = new Node<T>(data, tail);
    }

    public void deleteFromFront() {
        head = head.next;
    }

    public void deleteFromBack() {
        //create a node to travers the list
        Node<T> current = head;
        //traverse the list
        while (current.next != tail) {
            current = current.next;
        }
        //set tail to the current note
        tail = current;
        //set the tail to null removing the reference to the previous tail
        tail.next=null;
    }

    public void addAtIndex(T data, int index) {
        Node<T> newNode = new Node<>(data);
        Node<T> temp;
        Node<T> current;

        temp = head;
        current = null;

        //travers to the middle of the lsit
        for (int i = 0; i < index; i++) {
            current = temp;
            temp = temp.next;
        }
        current.next = newNode;
        newNode.next=temp;
        size++;
    }


    public void display() {
        //Node current will point to head
        Node current = head;
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Adding nodes to the end of the list: ");
        while(current != null) {
            //Prints each node by incrementing pointer
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }



    public static void main(String[] args) {
        SinglyLinkedList <String> foo = new SinglyLinkedList<String>();
        foo.addToFront("a");
        foo.addToFront("b");
        foo.addToFront("c");
        foo.addToBack("x");
        foo.addToBack("y");
        foo.addToBack("z");
        foo.addAtIndex("q", 3);

        foo.display();
    }

}
