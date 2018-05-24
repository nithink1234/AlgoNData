import java.util.*;

//Time Complexity: O(n). Space Complexity: O(n).
public class AD_Level_order_Traversal extends BinaryTree {

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

		Levelorder(bt.root);
	}

	
	static void Levelorder(TreeNode root) {
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		
		TreeNode current = root;
		q.add(current);
		
		while(!q.isEmpty()) {
			
			current = q.poll();
			if(current!= null) {
				System.out.println(current.data);
			}
			
			if(current.left != null) {
				q.add(current.left);
			}
			
			if(current.right!=null) {
				q.add(current.right);
			}
		}
	}
}
