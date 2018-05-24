import java.util.*;
public class AU_Merge_2Binary_Trees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static TreeNode mergeTreesitr(TreeNode t1, TreeNode t2) {
		if(t1 == null || t2 == null) {
			return t1;
		}
		
		Queue<TreeNode> q = new LinkedList<TreeNode>(); 
		q.add(t1);
		q.add(t2);
		
		while(!q.isEmpty()) {
			
			t1 = q.poll();
			t2 = q.poll();
			
			if(t1.left != null)
				q.add(t1.left);
			else
				q.add(null);
			
			if(t2.left != null)
				q.add(t2.left);
			else
				q.add(null);
			
			if(t1.right != null)
				q.add(t1.right);
			else
				q.add(null);
			
			if(t2.right != null)
				q.add(t2.right);
			else
				q.add(null);
			
			
			
			if(t1 != null && t2!= null) {
				t1.data = t1.data + t2.data;
			}
			
			else if(t1 == null && t2!= null) {
				t1 = t2;
			}
			
		}
		
		return t1;
	}

	
	static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		
		if(t1 != null ) {
			return t1;
		}
		
		if(t2!= null) {
			return t2;
		}
		
		t1.data = t1.data + t2.data;
		t1.left = mergeTrees(t1.left,t2.left);
		t1.right = mergeTrees(t2.right,t2.right);
		
		
		return t1;
	}
}
