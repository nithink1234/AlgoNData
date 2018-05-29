/*
 * Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]

Follow up: Recursive solution is trivial, could you do it iteratively?

 */

import java.util.*;
public class AB_In_order_Traversal extends BinaryTree {

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
		
		
		//Inorder_Recursion(bt.root);
		List<Integer> result = new ArrayList<Integer>();
		result = inOrderTraversal(bt.root);
		
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
		
	}
	
	static void Inorder_Recursion(TreeNode root) {
		
		if(root == null) {
			return;
		}
		
		Inorder_Recursion(root.left);
		System.out.println(root.data);
		Inorder_Recursion(root.right);
		
	}
	
	
	static List<Integer> inOrderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();
        
        //Null case
        if(root== null)
            return result;
        
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode current = root;
        
        // the current wont be null in case there are left nodes 
        // if current is null , n stack isn't empty , its in leaf node
        // So pop and set it to its right child n repeate 
        while(current!= null || !st.isEmpty()){
            
            // In this case there are more left nodes .. so push all
            while(current !=null){
                st.push(current);
                current = current.left;
            }
            
            current = st.pop();
            result.add(current.data);
            current = current.right;
        }
        
        return result;
        
	}

}
