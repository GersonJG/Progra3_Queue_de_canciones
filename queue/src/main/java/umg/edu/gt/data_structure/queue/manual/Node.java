package umg.edu.gt.data_structure.queue.manual;


public class Node<T> {
     private T value; 
    private Node<T> next;

    Node(T value) {
        this.value = value; 
    }

    public T getValue() {
    	return value;
    }
    
    public Node<T> getNext() {
    	return next; 
    	
    }
    
    public void setNext(Node<T> next){
    	this.next = next; 
    }
}





