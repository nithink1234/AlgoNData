/*
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]

 */
import java.util.*;
public class BD_zigzagLevelOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static List<List<Integer>> zigzagLevelOrder(TreeNode root){
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if(root == null)
			return result;
		
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);

		TreeNode current = root;
		int size = 0;
		int count = 0;
		
		while(!q.isEmpty()) {
			// The elements in q at this stage will all be in one level
			size = q.size();
			List<Integer> newlevel = new ArrayList<Integer>();
			
			// Iterate thru all those elements and add elements for next level
			for(int i=0; i<size; i++) {
				current = q.poll();
				
				if(current.left!= null)
					q.add(current.left);
				
				if(current.right != null)
					q.add(current.right);
				
				newlevel.add(current.data);
			}
		
			// Keep count on levels and Reverse for every even level 
			count ++;
			if(count%2 == 0) {
				Collections.reverse(newlevel);
			}
				
			result.add(newlevel);
		}
		
		return result;
	}

}
