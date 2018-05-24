
public class A_minHeap {

	int capacity = 10;
	int size = 0;
	int[] heap = new int[capacity];
	
	// Gives the value of first element 
	public int peek() {
		
		if( size == 0)
			throw new IllegalStateException();
		
		return heap[0];
		
	}
	
	// Return value of first element and removes it
	public int poll() {
		
		if( size == 0)
			throw new IllegalStateException();
		
		int element = heap[0];
		
		// Copy last element to first , reduce size of array
		// Order the heap down
		
		heap[0] = heap[size -1];
		size --;
		heapifyDown();
		
		return element;
	}
	
	
	public void insert(int item) {
		
	// ensure extra capacity to add item and add it in the end 
	// Order the heap up 
		
		ensureExtraCapacity();
		heap[size-1] = item;
		size++;
		heapifyUp();
		
	}
	
	public void heapifyUp() {
		
		int itemIndex = size -1;
		
		// Item is inserted in leaf node 
		// Move the item up as long as item has a parent and parent is bigger than item 
		while(hasParent(itemIndex) && parent(itemIndex)> heap[itemIndex]) {
			
			// Swap it with parent and walk upwards
			swap(getParentIndex(itemIndex), itemIndex );
			itemIndex = getParentIndex(itemIndex);
		}
	}
	
	public void heapifyDown() {
		int itemIndex = 0;
		
		while(hasLeftChild(itemIndex) && (heap[itemIndex] > getLeftChild(itemIndex))) {
			
			int smallerchildIndex = getLeftChildIndex(itemIndex);
			
			if(hasRightChild(itemIndex) && getLeftChild(itemIndex) > getRightChild(itemIndex)) {
				smallerchildIndex = getRightChildIndex(itemIndex);
			}
			
			if(heap[itemIndex] > heap[smallerchildIndex]) {
				swap(heap[itemIndex],heap[smallerchildIndex]);
			}
			else {
				break;
			}
			
			itemIndex = smallerchildIndex;
		}
	}
	
	
	public boolean hasLeftChild(int index) {
		
		return false;
	}
	
	public boolean hasRightChild(int index) {
		
		return false;
	}
	
	
	public int getLeftChild(int index) {
		
		return 0;
	}
	public int getRightChild(int index) {
		
		return 0;
	}
	
	
	public int getLeftChildIndex(int index) {
		
		return 0;
	}
	public int getRightChildIndex(int index) {
		
		return 0;
	}
	
	public boolean hasParent(int index) {
		
		if(index > 0)
			return true;
		
		return false;
	}
	
	public int parent(int index) {
		
		return 0;
	}
	
	public int getParentIndex(int index) {
		
		return 0;
	}
	
	public void swap(int parentIndex, int ItemIndex) {
		
	}
	public void ensureExtraCapacity() {
		
	}
}
