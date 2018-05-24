import java.util.*;

public class AK_Height_Depth_Tree {

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
		
		System.out.println("height : " + height_tree(bt.root));
		
		System.out.println("height Non rec : " + height_tree_nonrec(bt.root));
		
	}
	
	// Recursive 
	// Calc Left first. At each node comapre if left / right is big
	// return the big one and add 1 to account to the current node
	static int height_tree (TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		
		int left = height_tree(root.left);
		int right = height_tree(root.right);
		
		if(left > right) {
			return 1+ left;
		}
		
		return 1 + right;
	}

	//Non Recursive
	// Do level Order Traversal // At the start add root n null 
	// Add null when ever u encounter a null n q has nodes n increment size by 1.
	// i.e add null at the end of each level . so u can keep count on number of levels i.e height
	static int height_tree_nonrec (TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		
		TreeNode current = root;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		q.add(null);
		int size = 1;
		
		while(!q.isEmpty()) {
			
			current = q.poll();
			
			if(current == null && !q.isEmpty()) {
				size++;
				q.add(null);
			}
			
			else if (current != null) {
				
				if(current.left != null) {
					q.add(current.left);
				}
				
				if(current.right != null) {
					q.add(current.right);
				}
			}
			
			
		}
		
		return size;
	}
}
