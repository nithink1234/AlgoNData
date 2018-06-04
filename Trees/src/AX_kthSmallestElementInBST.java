/*
 * Given a binary

 */
public class AX_kthSmallestElementInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Time O(N log N) Log n to traverse the tree, N to count the left subelements every time
	// When we traverse BST in order, we iterate elements from smallest to largest
	static int kthsmallest(TreeNode root, int k) {
		
		// Get the size of left subtree
		int count = size(root.left);
		
		// count is num of elements in left .. so if its the next element then its root
		if(k == count +1)
			return root.data;
		// if its bigger than count of left subtree eleemnts then its in right subtree 
		if(k > count +1)
			return kthsmallest(root.right, k-count-1);
		
		// case when its in left subtree
		return kthsmallest(root.left, k);
	}
	
	static int size(TreeNode root) {
		
		if( root == null)
			return 0;
		
		return size(root.left) + size(root.right) + 1;
	}
	
}
