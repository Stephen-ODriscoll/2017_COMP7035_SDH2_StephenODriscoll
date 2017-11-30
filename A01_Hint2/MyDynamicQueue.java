
public class MyDynamicQueue implements MyQueue {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------

	private MyNode head;
	private int numItems;
	
	//-------------------------------------------------------------------
	// Basic Operation --> Check if MyQueue is empty: myCreateEmpty
	//-------------------------------------------------------------------		
	public MyDynamicQueue(){

		this.numItems = 0;
		this.head = null;
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Check if MyQueue is empty: isEmpty
	//-------------------------------------------------------------------	
	public boolean isEmpty(){

		return (this.numItems == 0);
	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get first element from front of MyQueue: first
	//-------------------------------------------------------------------
	public int first(){

		if (this.numItems == 0) {
			System.out.println("ERROR - Queue is empty");
			return -1;
		}
		
		else
			return this.head.getInfo();
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyQueue: add 
	//-------------------------------------------------------------------
	public void add(int element){
		
		if (this.numItems == 0)
			this.head = new MyNode(element, null);
		
		else {
			
			MyNode node = this.head;
			MyNode next = new MyNode(element, null);
			
			while (node.getNext() != null)
				node = node.getNext();
			
			node.setNext(next);
		}
		this.numItems++;
	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyQueue: remove 
	//-------------------------------------------------------------------	
	public void remove(){

		if (this.numItems == 0)
			System.out.println("ERROR - Queue is empty");
		
		else {
			this.head = this.head.getNext();
			this.numItems--;
		}
	}
	
}
