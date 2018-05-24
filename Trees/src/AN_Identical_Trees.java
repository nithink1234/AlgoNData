
public class AN_Identical_Trees {

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

	}

	static boolean identical (TreeNode root1, TreeNode root2) {
		
		if(root1 == null && root2 == null)
			return true ;
		
		if((root1 == null && root2 != null) || (root1 != null && root2 == null) || (root1.data != root2.data)) {
			return false;
		}
		
		return identical(root1.left, root2.left) && identical(root1.right, root2.right);
	}
	
}
