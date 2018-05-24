import java.util.*;
public class AB_In_order_Traversal extends BinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTree bt = new BinaryTree();
		
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
		
		
		//Inorder_Recursion(bt.root);
		
		inOrderTraversal(bt.root);
	}
	
	static void Inorder_Recursion(TreeNode root) {
		
		if(root == null) {
			return;
		}
		
		Inorder_Recursion(root.left);
		System.out.println(root.data);
		Inorder_Recursion(root.right);
		
	}
	
	
	static void inOrderTraversal(TreeNode root) {
		
		if(root != null) {
			
			Stack<TreeNode> st = new Stack<TreeNode>();
			st.add(root);
			
			TreeNode current = root;
			
			// Add all the left nodes initially 
			while(current != null) {
				st.push(current);
				current = current.left;
			}
			
			// When no more left nodes 
			while(!st.isEmpty()) {
				
				// Pop and print 
				current = st.pop();
				System.out.print(current.data + " ");
				
				// Add right if present 
				if(current.right != null) {
					current = current.right;
					
					// Add all left nodes again 
					while(current != null) {
						st.push(current);
						current = current.left;
					}
				}
				
			}
		}
	}

}
