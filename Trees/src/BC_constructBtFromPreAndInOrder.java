
public class BC_constructBtFromPreAndInOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		buildTree(preorder);
	}
	
	// U need to define start and end for both pre and inorder array 
	static TreeNode buildTree(int[] preorder, int[] inorder, int rootIndex, int instart, int inend, int prestart) {
		
		//Null Case .. reached end of tree
		if(instart>inend || prestart>preorder.length-1)
			return null;
		
		// Mark the first element in preOrder to be root. 
		TreeNode root = new TreeNode(preorder[prestart]);
		
		// Find the index of root in inorder  ..
		// Start and end are the start and end of the in order array to be considered
		for(int i=instart; i<inend; i++) {
			if(root.data == inorder[i]) {
				rootIndex = i;
				break;
			}
		}
		
		int leftlength = rootIndex - instart;
		
		// The elements left to this index will be left subtree , and right .. right subtree
		root.left = buildTree(preorder,inorder,rootIndex,instart,rootIndex-1,prestart+1);
		root.right = buildTree(preorder,inorder,rootIndex,rootIndex+1,inend,prestart+1+leftlength);
		
		return root;
	}

}
