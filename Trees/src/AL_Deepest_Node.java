import java.util.*;
public class AL_Deepest_Node {

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
		
		System.out.println("Deepest node is: " + deepnode(bt.root).data);
		
	}

	// Do level Order Traversal .. The end element in the q.. i.e current will be the deepest node. 
	static TreeNode deepnode(TreeNode root) {
		
		if(root == null) {
			return root;
		}
		
		TreeNode current = root;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		
		while(!q.isEmpty()) {
			
			current = q.poll();
			
			if(current.left != null) {
				q.add(current.left);
			}
			
			if(current.right != null) {
				q.add(current.right);
			}
		}
		
		return current;
	}
}
