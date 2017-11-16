
public class MyStaticQueue implements MyQueue {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------

	private int items[];
	private int numItems;
	private int maxItems;

	//-------------------------------------------------------------------
	// Basic Operation --> Check if myQueue is empty: myCreateEmpty
	//-------------------------------------------------------------------	
	public MyStaticQueue(int m){

		this.maxItems = m;
		this.items = new int[this.maxItems];
		this.numItems = 0;

	}
	
	//-------------------------------------------------------------------
	// Basic Operation --> Check if MyQueue is empty: isEmpty
	//-------------------------------------------------------------------	
	public boolean isEmpty() {
		
		return (this.numItems == 0);
	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get first element from front of MyQueue: first
	//-------------------------------------------------------------------
	public int first(){
		
		if (this.numItems == 0) {
			
			System.out.println("ERROR: Queue is empty");
			return -1;
		}
		
		else
			return this.items[0];
	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Add element to back of MyQueue: add 
	//-------------------------------------------------------------------
	public void add(int element){

		if (this.numItems < this.maxItems) {
			
			this.items[numItems] = element;
			numItems++;
		}
		else
			System.out.println("ERROR: Queue is full");
		
	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyQueue: remove 
	//-------------------------------------------------------------------	
	public void remove(){

		if (this.numItems != 0) {
			
			for (int i=0; i < this.numItems-1; i++)
				this.items[i] = items[i+1];
			
			this.numItems --;
			this.items[numItems] = 0;
		}
		else
			System.out.println("ERROR: Queue is empty");
	}
	
}
