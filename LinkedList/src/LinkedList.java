class Node {
	      
	int data;
	Node next;
	
	      
	public Node(int data) {
		this.data = data;
		next = null;
	}
}

public class LinkedList {
	
	Node head;
	
	// Constructors
    LinkedList(int data)
    {
        head = new Node(data);
    }
 
    LinkedList()
    {
        head = null;
    }
	
}