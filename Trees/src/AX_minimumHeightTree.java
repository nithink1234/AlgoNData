/*
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its minimum depth = 2.

 */
public class AX_minimumHeightTree {

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

		
		System.out.println("Min height is: " + Minheight(bt.root));
	}

	/*
	 * 	 Same thing as max but send the minimum of left and right 
		 Don’t forget the case when root has only 1 child. Then it will send  0 to even though its not
		 So check if either left or right is null .. If so send 1+left+right
	 */
	static int Minheight(TreeNode root) {
		
		if(root == null)
			return 0;
		
		int left = Minheight(root.left);
		int right = Minheight(root.right);
		
		if(left == 0 || right == 0)
			return left + right + 1;
		
		return Math.min(left,right) + 1;
	}
}
