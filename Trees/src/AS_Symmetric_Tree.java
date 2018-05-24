/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3

Note:
Bonus points if you could solve it both recursively and iteratively. 
 */

import java.util.*;
public class AS_Symmetric_Tree {

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
		
		BinaryTree bt1 = new BinaryTree();
		
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(2);
		bt.root.left.left = new TreeNode(3);
		bt.root.left.right = new TreeNode(4);
		bt.root.right.left = new TreeNode(4);
		bt.root.right.right = new TreeNode(3);
		bt.root.left.right.left = new TreeNode(5);
		bt.root.right.left.right = new TreeNode(5);
		
		System.out.println("Symmetric rec bt: " + isSymmetric(bt.root));
		System.out.println("Symmetric rec bt1: " + isSymmetric(bt1.root));

	}

	
	// Recursive 
	// Take 2 copies of root 
	// check recursively if left of 1 is = right of other && right of 1 = left of other
	// Return false whenever its not equal
	static boolean isSymmetric(TreeNode root) {
		
		return ismirror(root,root);
	}
	
	static boolean ismirror(TreeNode rootl, TreeNode rootr) {
		
		if(rootl == null && rootr == null)
			return true;
		
		if(rootl == null || rootr == null)
			return false;
		
		return (rootl.data == rootr.data) && ismirror(rootl.left, rootr.right) && ismirror(rootl.right, rootr.left);
	}
	
	
	// Non recursive 
	// Same thing with a queue 
	// Add root twice and pop both and add  left of 1 is & right of other && right of 1 & left of other
	// So that they all queue up in order .. so u can pop 2 at a time n compare
	static boolean ismirror_itr(TreeNode root) {
		
		if(root == null)
			return true;
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode t1 = null;
		TreeNode t2 = null;
		q.add(root);
		q.add(root);
		
		while(!q.isEmpty()) {
			t1 = q.poll();
			t2 = q.poll();
			
			if(t1 == null && t2 == null)
				return true;
			
			if(t2 == null || t2 == null)
				return false;
			
			if(t1.data != t2.data)
				return false;
			
			q.add(t1.left);
			q.add(t2.right);
			q.add(t1.right);
			q.add(t2.left);
		}
		
		return true;
	}
}
