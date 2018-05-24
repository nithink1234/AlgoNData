
public class AE_DeleteElement {

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
		
	}

	static TreeNode delete(TreeNode root, int data) {
		
		// Element not present
		if(root == null)
			return root;
		
		else if(data > root.data)
			root.right = delete(root.right, data);
		
		else if(data< root.data)
			root.left = delete(root.left, data);
		
		// When the element is found
		else {
			
			// If its a leaf node delete it
			if(root.left == null && root.right == null) {
				return null;
			}
			
			// if it has 1 child.. copy the child to node delete child
			else if(root.left == null && root.right != null) {
				return root.right;
			}
			else if(root.right == null && root.left != null) {
				return root.left;
			}
			
			// node with two children: Get the inorder successor (smallest
            // in the right subtree)
			
		}
		
		return root;
	}
}
