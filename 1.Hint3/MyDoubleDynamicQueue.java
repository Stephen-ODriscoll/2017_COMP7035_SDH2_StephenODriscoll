
public class MyDoubleDynamicQueue<T> implements MyQueue<T> {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------

	private MyDoubleLinkedNode<T> head;
	private MyDoubleLinkedNode<T> tail;
	
	//-------------------------------------------------------------------
	// Basic Operation --> Check if myQueue is empty: myCreateEmpty
	//-------------------------------------------------------------------	
	public MyDoubleDynamicQueue(){

		this.head = new MyDoubleLinkedNode<T>(null, null, null);
		this.tail = this.head;
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Check if myQueue is empty: isEmpty
	//------ -------------------------------------------------------------	
	public boolean isEmpty(){

		return (this.head.getInfo() == null);
	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get first element from front of MyQueue: first
	//-------------------------------------------------------------------
	public T first(){

		if (this.head.getInfo() == null)
			System.out.println("ERROR - Queue is empty");
		
		return this.head.getInfo();
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyQueue: addByFirst 
	//-------------------------------------------------------------------
	public void addByFirst(T element){
		
		if (this.head.getInfo() == null)
			this.head.setInfo(element);
		
		else {

			MyDoubleLinkedNode<T> node = new MyDoubleLinkedNode<T>(null, element, this.head);
			
			this.head.setLeft(node);
			this.head = node;
		}
	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyQueue: removeByFirst 
	//-------------------------------------------------------------------	
	public void removeByFirst(){

		if (this.head.getInfo() == null)
			System.out.println("ERROR - Queue is empty");
		
		else if (this.head == this.tail)
			this.head.setInfo(null);
		
		else {
			
			this.head = this.head.getRight();
			this.head.setLeft(null);
		}
	}

	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get first element from front of MyQueue: last
	//-------------------------------------------------------------------
	public T last(){

		if (this.tail.getInfo() == null)
			System.out.println("ERROR - Queue is empty");
		
		return this.tail.getInfo();
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyQueue: addByLast 
	//-------------------------------------------------------------------
	public void addByLast(T element){
		
		if (this.tail.getInfo() == null)
			this.tail.setInfo(element);
		
		else {
			
			MyDoubleLinkedNode<T> node = new MyDoubleLinkedNode<T>(this.tail, element, null);
			
			this.tail.setRight(node);
			this.tail = node;
		}
	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyQueue: removeByFirst 
	//-------------------------------------------------------------------	
	public void removeByLast(){

		if (this.tail.getInfo() == null)
			System.out.println("ERROR - Queue is empty");
		
		else if (this.tail == this.head)
			this.tail.setInfo(null);
		
		else {
			
			this.tail = this.tail.getLeft();
			this.tail.setRight(null);
		}
	}
	
}
