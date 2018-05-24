
public class AC_MaxElement {

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
		
		System.out.println("Max Value :" + max(bt.root));
		
		System.out.println("Max Value :" + max_nonrec(bt.root));
		
	}

	// Rec 
	// Go to the rightmost element to get max value
	static int max(TreeNode root) {
		
		if(root == null)
			return 0;
		
		if(root.right == null)
			return root.data;
		
		return max(root.right);
	}
	
	//Non recursive 
	static int max_nonrec(TreeNode root) {
		
		if(root == null)
			return 0;
		
		while(root.right != null)
			root = root.right;
		
		return root.data;
	}
	
}
