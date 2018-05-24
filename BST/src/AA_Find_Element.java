
public class AA_Find_Element {

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
		
		System.out.println("Element: " + find(bt.root, 7).data);
		
		System.out.println("Element: " + find_nonrec(bt.root, 7).data);

	}

	// Recursive
	static TreeNode find(TreeNode root, int data) {
		
		if(root == null)
			return null;
		
		 if (data < root.data)
			return find(root.left, data);
		
		 if(data > root.data)
			return find(root.right, data);
		
		return root;
	}
	
	// Non Recursive
	static TreeNode find_nonrec(TreeNode root, int data) {
		
		if(root == null)
			return null;
		
		TreeNode current = root;
		
		while(current!= null) {
			
			if(current.data == data)
				return current;
			
			else if(data < current.data)
				current = current.left;
			
			else if(data > current.data)
				current = current.right;
		}
		
		return current;
	}
}
