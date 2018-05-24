import java.util.*;
public class AW_leafNodesToArray {

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
		
		
		int[] arr = leafnodesarray(bt.root);
		
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i]);
		

	}

	
	static int[] leafnodesarray(TreeNode root) {
		
		int[] empty = new int[0];
		
		if(root == null)
			return empty;
		
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		TreeNode current = root;
		q.add(root);
		
		while(!q.isEmpty()) {
			
			current = q.poll();
			
			if(current.left != null)
				q.add(current.left);
			
			if(current.right != null)
				q.add(current.right);
			
			if(current.left == null && current.right == null)
				al.add(current.data);
		}
		
		int[] nodes = new int[al.size()];
		
		for(int i=0; i<nodes.length; i++) {
			nodes[i] = al.get(i);
		}
		
		return nodes;
	}
}
