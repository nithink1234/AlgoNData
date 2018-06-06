/*
 * Given a singly linked list, find middle of the linked list. For example, if given linked list is 1->2->3->4->5 then output should be 3.

If there are even nodes, then there would be two middle nodes, we need to print second middle element. 
For example, if given linked list is 1->2->3->4->5->6 then output should be 4.
 */
public class AA_findMiddleElementOfLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	static Node middle(Node head) {
		
		Node current= head; 
		Node fast = head;
		
		while(current != null) {
			
			// in case of odd length LL .. fast == null is when the length is even 
			if(fast.next == null || fast == null)
				break;
			
			// Move slow by 1 and fast twice
			current = current.next;
			fast = fast.next.next;
		}
		
		return current;
	}

}
