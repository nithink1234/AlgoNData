class TreeLinkNode {
     
	 int val;
     TreeLinkNode left, right, next;
     
     TreeLinkNode(int x) 
     { 
    	 val = x; 
     }
     
  }

public class BE_popluateNextRightPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void connect (TreeLinkNode root) {
		
		//Null case
		if(root  == null)
			return;
		
		root.next = null;
		connectFullBT(root);
	}
	
	 static void connectFullBT (TreeLinkNode root) {
		 
		 //Base Case
		 if(root == null)
			 return ;
		 
		 // Set the next of left child as right child
		 if(root.left != null) {
			 root.left.next = root.right;
		 }
		 
		 // For right child there are 2 cases 
		 if(root.right != null) {
			 
			 // if its rightmost child(root next will be null ), the next of right child will also be null 
			 if(root.next == null) {
				 root.right.next = null;
			 }
			 // otherwise its inbtw the tree.. its next will be the left child of root next. 
			 else {
				 root.right.next = root.next.left;
			 }
			 
		 }
		 
		 //do this for entire tree. 
		 connectFullBT(root.left);
		 connectFullBT(root.right);
		 
	 }
}
