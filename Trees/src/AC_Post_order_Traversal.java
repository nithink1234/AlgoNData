/*
 * Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]

Follow up: Recursive solution is trivial, could you do it iteratively?
 */
import java.util.*;
public class AC_Post_order_Traversal extends BinaryTree{

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
		
		List<Integer> result = new ArrayList<Integer>();
		//Post_order_Recursion(bt.root);
		result = postOrderIteravtive(bt.root);
		
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	
	static void Post_order_Recursion(TreeNode root) {
		
		if(root == null) {
			return;
		}
		
		Post_order_Recursion(root.left);
		Post_order_Recursion(root.right);
		System.out.println(root.data);
	}
	
	static List<Integer> postOrderIteravtive(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        
        TreeNode current = root;
        Stack<TreeNode> st1 = new Stack<TreeNode>();
        Stack<TreeNode> st2 = new Stack<TreeNode>();
        st1.push(root);
        
        // Push left and right node of current in that order to stack 1 
        // each time u pop stack 1 add it to stack 2 .. ull get postorder in reverse
        while(!st1.isEmpty()){
            current = st1.pop();
            st2.push(current);
            
            if(current.left != null)
                st1.push(current.left);
            
            if(current.right != null)
                st1.push(current.right);
        }
        
        // all the nodes are in reverse order in stack 2 .. so pop n print
        while(!st2.isEmpty()){
            result.add(st2.pop().data);
        }
        
        return result;
    }
}
