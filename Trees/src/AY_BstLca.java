
public class AY_BstLca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int LCA(TreeNode root, int a, int b) {
		
		if(root == null)
			return 0;
		
		if(a < root.data && b < root.data)
			LCA(root.left, a, b);
		
		else if (a > root.data && b > root.data)
			LCA(root.right, a, b);
		
			return root.data;
	}

}
