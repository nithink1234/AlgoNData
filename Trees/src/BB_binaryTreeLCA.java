
public class BB_binaryTreeLCA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Another way to do it.. store root to path for p and q in two arryas ... then iterate thru both 
	// and find last common one .. that is LCA.. takes space 
	
	// Check in left subtree and then right if there is p, q  
	// if p, q is found return it to top.. no need to further search down the tree 
	// search for it left and right subtree. if not found
	// if u get one from left and one from right.. that is lca so return itself
	// else it means one of the node was found return that to top
	static TreeNode binaryTreeLCA (TreeNode root, TreeNode p, TreeNode q) {
		
		// Edge case 
		if(root == null)
			return null;
		
		// First check if the root is either p or q.. if it is no need to search further down return the node that we found
		// Modify: this condition can be written as if(root == p || root == q) return root.. its the same
		if(root.data == p.data)
			return p;	
		else if(root.data == q.data)
			return q;
		
		// If its not p or q .. then we have to search for it down the tree
		TreeNode left = binaryTreeLCA(root.left,p,q);
		TreeNode right = binaryTreeLCA(root.right,p,q);
		
		// That means root is LCA so just return it
		if(left!= null && right != null) 
			return root;
		
		// if the p,q is found in its left or right subtree return that 
		if(left!=null)
			return left;
		
		return right;
	}
}
