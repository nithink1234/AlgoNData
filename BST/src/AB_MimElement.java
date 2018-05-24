
public class AB_MimElement {

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
		
		System.out.println("Mim Element: " + mim(bt.root));
		
		System.out.println("Mim Element: " + mim_nonrec(bt.root));
		
	}

	// Recursive
	// Go to the leftmost element to get the root. 
	static int mim (TreeNode root) {
		
		if(root == null)
			return 0;
		
		if(root.left == null)
			return root.data;
		
		return mim(root.left);
	}
	
	//Non Recursive
	static int mim_nonrec(TreeNode root) {
		
		if(root == null)
			return 0;
		
		while( root.left != null)
			root = root.left;
		
		return root.data;
	}
}
