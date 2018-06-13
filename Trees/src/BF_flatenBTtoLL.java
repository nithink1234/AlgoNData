/*
 * Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6

The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6


 */
public class BF_flatenBTtoLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// To get linked list in postorder 
	static TreeNode prev = null;
	static void flatten(TreeNode root) {
		
		if(root == null)
			return;
		
		// Do reverse of postorder
		flatten(root.right);
		flatten(root.left);
		
		// It will start from 6 and work its way upwards
		root.right = prev;
		root.left = null;
		prev = root;
	}
	

}
