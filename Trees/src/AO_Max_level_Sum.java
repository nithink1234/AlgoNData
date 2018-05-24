import java.util.*;

public class AO_Max_level_Sum {

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

		
		System.out.println("Max sum at level is: " + Max_level(bt.root));
	}
	
	// Same as level order .. add elements btw nulls and get max 
	static int Max_level (TreeNode root) {
		
		if(root == null)
			return 0;
		
		TreeNode current = root;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		q.add(null);
		int sum =0;
		int max =0;
		
		while(!q.isEmpty()) {
			current = q.poll();
			
			if(current == null && !q.isEmpty()) {
				if(sum> max)
					max = sum;
				
				sum = 0;
				q.add(null);
			}
			
			else if(current != null) {
				sum += current.data;
				
				if(current.left != null)
					q.add(current.left);
				
				if(current.right != null)
					q.add(current.right);
			}
		}
		
		return max;
	}

}
