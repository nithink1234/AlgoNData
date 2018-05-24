
public class AD_InsertElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		A_BinaryTree bt = new A_BinaryTree();
		
		bt.root = new TreeNode(8);
		bt.root.left = new TreeNode(3);
		bt.root.right = new TreeNode(10);
		bt.root.left.left = new TreeNode(1);
		bt.root.left.right = new TreeNode(6);
		bt.root.left.right.left = new TreeNode(4);
		bt.root.left.right.right = new TreeNode(7);
		bt.root.right.right = new TreeNode(15);
		bt.root.right.right.left = new TreeNode(13);
		bt.root.right.right.left.right = new TreeNode(14);
		
		
	}
	
	// Rec 
	// Node always inserted at the leaf 
	// Find the element , replace null with newnode 
	
	static TreeNode insert(TreeNode root, int data) {
		
		if(root == null) {
			TreeNode newnode = new TreeNode(data);
			return newnode;
		}
				
		else if( data > root.data)
			root.right = insert(root.right, data);
		
		else if( data < root.data)
			root.left = insert(root.left,data);
		
		return root;
	}

	// Non Rec 
	static TreeNode insert_nonrec(TreeNode root, int data) {
		
		TreeNode newnode = new TreeNode(data);
		TreeNode current = root;
		
		if(root == null) {
			return newnode;
		}
		
		while(current != null) {
			
			if(current.data == data)
				return current;
			
			else if(data > current.data) {
				
				if(current.right == null) {
					current.right = newnode;
					return root;
				}
				else
					current = current.right;
			}
			
			else if(data < current.data) {
				
				if(current.left == null) {
					current.left = newnode;
					return root;
				}
				else
					current = current.left;
			}
		}
		
		return root;
	}
	
	
	//Another way
	static TreeNode insert_nonrec2(TreeNode root, int data) {
		
		TreeNode newnode = new TreeNode(data);
		TreeNode current = root;
		TreeNode parent = null;
		
		if(root == null) {
			return newnode;
		}
		
		while(current!= null) {
			parent = current;
			
			if(current.data == data)
				return current;
			
			else if(data > current.data) 
				current = current.right;
			
			else if(data < current.data)
				current = current.left;
			
		}
		
		if(data > parent.data) 
			parent.right = newnode;
		
		else if(data < parent.data) 
			parent.left = newnode;
		
		return root;
	}
}
