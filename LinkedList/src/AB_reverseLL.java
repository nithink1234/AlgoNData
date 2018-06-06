/*
 * Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

 */
public class AB_reverseLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	static Node reverse(Node head) {
		
		Node next = null ;
		Node prev = null;
		Node current = head;
		
		// take the hold the next address of a node
		// add prev node to next add field
		// store current node as prev before u move on 
		// move to next .. In the end current will be null and prev will be head 
		while(current != null) {
		
			next = current.next;
			current.next = prev;
			prev = current;
			
			current = next;
			
		}
		return prev;
	}

}
