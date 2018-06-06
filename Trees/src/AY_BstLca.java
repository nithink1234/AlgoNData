
public class AY_BstLca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int LCA(TreeNode root, int a, int b) {
		
		while(root != null) {
			
			if(a < root.data && b<root.data) {
				root = root.left;
			}
			else if(a > root.data && b>root.data)
				root= root.right;
			else
				break;
			
		}
		
		return root.data;
	}

}
