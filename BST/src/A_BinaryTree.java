
class TreeNode {
	      
	int data;
	TreeNode left;
	TreeNode right;
	      
	public TreeNode(int data) {
		this.data = data;
		left = right = null;
	}
}

public class A_BinaryTree {
	
	TreeNode root;
	
	// Constructors
	A_BinaryTree(int data)
    {
        root = new TreeNode(data);
    }
 
	A_BinaryTree()
    {
        root = null;
    }
	
}