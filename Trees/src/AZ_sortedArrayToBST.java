
public class AZ_sortedArrayToBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
		
		int start = 0;
		int end = nums.length -1;
		
		return add(nums,start,end);
	}

	public TreeNode add(int[] nums, int start, int end) {
		
		if(start > end)
			return null;
		
		int middle = (start + end)/2;
		TreeNode root = new TreeNode(middle);
		
		root.left = add(nums,start,middle-1);
		root.right = add(nums,middle+1,end);
		
		return root;
	}
}
