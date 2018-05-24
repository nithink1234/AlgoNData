import java.util.*;
public class AM_Delete_Node {

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
		
	}
	
	static void deletenode(TreeNode root, int data1) {
		
		if(root != null) {
			TreeNode current = root;
			TreeNode delenode = null;
			TreeNode prevnode = null;
			TreeNode prev = root;
			Queue<TreeNode> q = new LinkedList<TreeNode>();
			q.add(root);
			
			while(!q.isEmpty()) {
				current = q.poll();
				
				if(current.data == data1) {
					delenode = current;
					prevnode = prev;
				}
				
				if(current.left != null) {
					q.add(current.left);
				}
				
				if(current.right != null) {
					q.add(current.right);
				}
				
				if(prevnode.left == delenode) {
					prevnode.left = current;
				}
				else if (prevnode.right == delenode) {
					prevnode.right = current;
				}
				
				current.left = delenode.left;
				current.right = delenode.right;
			}
			
			
		}
		
	}

}
