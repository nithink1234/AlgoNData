
class TreeNode {
	      
	int data;
	TreeNode left;
	TreeNode right;
	      
	public TreeNode(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BinaryTree {
	
	TreeNode root;
	
	// Constructors
    BinaryTree(int data)
    {
        root = new TreeNode(data);
    }
 
    BinaryTree()
    {
        root = null;
    }
	
}