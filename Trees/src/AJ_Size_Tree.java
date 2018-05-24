import java.util.*;

public class AJ_Size_Tree {

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
		
		System.out.println("Size of the tree:" + tree_size(bt.root));
		
		System.out.println("Size of the tree non rec:" + tree_size_lvl(bt.root));
		
	}
	
	// Recursive
	// Go to left till u reach null .. return with 0 when u do
	// if there is a right go right n then left again
	// each time u return add 1. ye
	static int tree_size (TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		
		int left = tree_size(root.left);
		int right = tree_size(root.right);
		
		return 1+ left + right;
	}
	
	
	// Non Recursive
	// Do level order t. If node isnt null size++
	static int tree_size_lvl (TreeNode root) {
		
		if(root != null) {
			return 0;
		}
		
		TreeNode current = root;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int size =0;
		
		while(!q.isEmpty()) {
			
			current = q.poll();
			
			if(current != null) {
				size++;
			}
			
			if(current.left != null) {
				q.add(current.left);
			}
			
			if(current.right != null) {
				q.add(current.right);
			}
		}
		
		return size;
	}
}
