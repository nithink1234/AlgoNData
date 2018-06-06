/*
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---


 */
import java.util.*;
public class BA_rightSideView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static List<Integer> rightview(TreeNode root){
		
		// Breadth first search .. last element in each level will be the rightmost one
		List<Integer> result = new ArrayList<Integer>();
		
		if(root!= null) {
			
			Queue<TreeNode> q = new LinkedList<TreeNode>();
			q.add(root);
			q.add(null);
			TreeNode current = root;
			TreeNode prev = root;
			
			while(!q.isEmpty()) {
				
				current = q.poll();
				
				if(current!= null) {
					prev = current;
					
					if(current.left!= null)
						q.add(current.left);
					
					if(current.right!= null)
						q.add(current.right);
				}
				
				// Reached end of a level .. in the end current will be null and q is considerd empty even if there are only nulls in it 
				else if(current == null && !q.isEmpty()) {
					result.add(prev.data);
					q.add(null);
				}
				
			}
			
			// To add the last leaf node
			result.add(prev.data);
		}
		
		return result;
	}
}
