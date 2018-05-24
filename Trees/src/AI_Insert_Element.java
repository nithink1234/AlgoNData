import java.util.*;
public class AI_Insert_Element {

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
		
		insertEle(bt.root, 20);
		
	}
	
	
	static void insertEle (TreeNode root, int num) {
		
		TreeNode current = root;
		TreeNode newnode = new TreeNode(num);
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		
		while(!q.isEmpty()) {
			
			current = q.poll();
			
			if(current != null) {
				
				if(current.left == null) {
					current.left = newnode;
				}
				else {
					q.add(current.left);
				}
				if(current.right == null) {
					current.right = newnode;
				}
				else {
					q.add(current.right);
				}
			}
		}
		
	}

}
