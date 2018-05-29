/*
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

    a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7

Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4

Return false.

 */

import java.util.*;
public class AV_Balanced_Binary_Tree {
	private static boolean result = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTree bt = new BinaryTree();
		
		bt.root = new TreeNode(5);
		bt.root.left = new TreeNode(4);
		bt.root.right = new TreeNode(8);
		bt.root.right.left = new TreeNode(13);
		bt.root.right.right = new TreeNode(4);
		bt.root.right.right.right = new TreeNode(1);


		System.out.println(balancedBinaryTree(bt.root));
		
		System.out.println(balanced(bt.root));
	}

	// Do same code as getting height but here check if height difference is more than 1 from 2 subtrees
	// this will need global variable to set boolean val 
	// can be done without it as well.. 
	static boolean balanced(TreeNode root) {
		maxdepth(root);
		return result;
	}
	
	static int maxdepth(TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		
		int left = maxdepth(root.left);
		int right = maxdepth(root.right);
		
		if(Math.abs(left - right) > 1)
			result = false;
		
		return 1 + Math.max(left, right);
	}
	
	
	
	static boolean balancedBinaryTree(TreeNode root) {
		
		if(root == null)
			return false;
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode current;
		int prevnodes =0;
		int currentnodes = 0;
		int lastbalancedlevel = 0;
		int currentlevel = 0;
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			
			current = q.poll();
			currentnodes++;
			
			if(current == null & !q.isEmpty()) {
				
				currentlevel ++ ;
				
				if(currentlevel - lastbalancedlevel > 1)
					return false;
				
				if(prevnodes!=0 && currentnodes != prevnodes*2) {
					lastbalancedlevel = currentlevel -1;
				}
				
				prevnodes = currentnodes;
				lastbalancedlevel = currentlevel;
				currentnodes = 0;
				
				q.add(null);
			}
			
			else if (current != null) {
				if(current.left != null)
					q.add(current.left);
				
				if(current.right != null)
					q.add(current.right);
			}
		}
		
		return true;
	}
}
