/*
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1

return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

 */


public class AT_Path_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTree bt = new BinaryTree();
		
		bt.root = new TreeNode(5);
		bt.root.left = new TreeNode(4);
		bt.root.right = new TreeNode(8);
		bt.root.left.left = new TreeNode(11);
		bt.root.right.left = new TreeNode(13);
		bt.root.right.right = new TreeNode(4);
		bt.root.right.right.right = new TreeNode(1);
		bt.root.left.left.left = new TreeNode(7);
		bt.root.left.left.right = new TreeNode(2);
		
		System.out.println(hasPathSum(bt.root, 15));

	}
	
	// Recursion 
	// take a int result and keep subtracting the passing nodes value from sum 
	// when it hits leaf check if result is 0 
	// check if left or right subtree it has to return true only once
	 static boolean hasPathSum(TreeNode root, int sum) {
	        
	        if(root == null)
	            return false;
	        
	        int result = sum - root.data;
	        
	        if(root.left == null && root.right == null )
	            return result == 0;
	        
	        return (hasPathSum(root.left, result) || hasPathSum(root.right, result)); 
	    }
	}
