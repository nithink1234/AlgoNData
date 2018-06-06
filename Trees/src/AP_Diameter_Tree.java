
public class AP_Diameter_Tree {

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
		
		System.out.println("Diameter: " + diameter(bt.root));
		
	}

	static int max;
	
	
	static int diameter (TreeNode root) {
		
		// in case of null .. it shouldnt return -1.. 
		max = 1;
        maxdepth(root);
        // Since u are only counting the edges ,its -1 
        // The original max returns number of nodes in longest path
		return max-1;
	}
	
	// Same as Max depth, just rememebr the max of number of nodes in each subtree.. -1 will give the path .. rememeber the max path
	static int maxdepth(TreeNode root) {
		if(root == null)
			return 0;
		 
		int left = maxdepth(root.left);
		int right = maxdepth(root.right);
		
		max = Math.max(max, left+right+1);
		
		return(Math.max(left+1, right+1));
	}
}
