
public class A_Binary_Tree_Node {
	
	//Instance Variables
	int data;
	A_Binary_Tree_Node left,right ;
	
	//Constructor
	public A_Binary_Tree_Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	//Methods
	
	public int GetData() {
		
		return data;
	}
	
	
	public void SetData(int newdata) {
		
		this.data = newdata;
	}
	
	public A_Binary_Tree_Node GetLeftNode() {
		
		return this.left;
	}
	
	public void SetLeftNode(A_Binary_Tree_Node Node) {
		
		this.left = Node;
	}
	
	public A_Binary_Tree_Node GetRightNode() {
		
		return this.right;
	}
	
	public void SetRightNode(A_Binary_Tree_Node Node) {
		
		this.right = Node;
	}

}
