import java.util.*;

public class AF_Find_Element {

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

		System.out.println("Max: " + findElement(bt.root, 5));

		 System.out.println("Max Rec: " + findEleRec(bt.root, 5));

	}
	
	
	static boolean findEleRec(TreeNode root, int element) {
		
		if(root == null)
			return false;
		
		if(root.data == element)
			return true;
		
		return findEleRec(root.left, element) || findEleRec(root.right, element) ;
	}
	

	static boolean findElement(TreeNode root, int element) {

		TreeNode current = root;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);

		while (!q.isEmpty()) {

			current = q.poll();
			if (current != null) {
				if (current.data == element) {
					return true;
				}

				if (current.left != null) {
					q.add(current.left);
				}

				if (current.right != null) {
					q.add(current.right);
				}
			}

		}

		return false;
	}

}
