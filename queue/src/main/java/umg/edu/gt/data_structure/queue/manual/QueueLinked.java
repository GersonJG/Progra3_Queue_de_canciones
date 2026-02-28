package umg.edu.gt.data_structure.queue.manual;

public class QueueLinked<T> {

    private Node<T> head; // primero en salir
    private Node<T> tail; // ultimo en entrar
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // add
    public void enqueue(T value) {
        Node<T> node = new Node<>(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    // delete
    public T dequeue() {
        if (isEmpty()) 
            throw new IllegalStateException("Queue underflow");
        
        T value = head.getValue();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue underflow");
        }
        return head.getValue();
    }

}
