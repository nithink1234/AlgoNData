
public class AF_ValidateBST {

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
		
		System.out.println(isbst(bt.root));
		
	}

	static boolean isbst(TreeNode root) {
		
		int prev = Integer.MIN_VALUE;
		return(validate(root,prev));
	}
	
	// Do in Order traversal so that the numbers have to be in increasing order 
	// Initialize previous value as mim  
	// every time it visits a node check that prev value has to be less than current value
	static boolean validate(TreeNode root, int prev) {
		
		if(root != null) {
			if(!isbst(root.left))
				return false;
			
			if(root.data <= prev)
				return false;
			
			prev = root.data;
			
			return isbst(root.right);
		}
		
		return true;
	}
}
