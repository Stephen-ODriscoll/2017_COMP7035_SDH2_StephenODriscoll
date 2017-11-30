
/**
 * The class contains the Divide and Conquer-based Algorithms we are using. 
 */
public class DivideAndConquerAlgorithms {

	//----------------------------------------------
	// Class constructor
	//----------------------------------------------	
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public DivideAndConquerAlgorithms(){}
		
	//-------------------------------------------------------------------
	// 0. iterativeDisplayElements --> Displays all elements of a MyList 
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this iterative algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void iterativeDisplayElements(MyList<Integer> m){
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 
		
		//Rule 1. MyList is empty
		if (m.length() == 0) 
			scenario = 1;
		//Rule 2. MyList is non-empty
		else
			scenario = 2;

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
				
		//Rule 1. MyList is empty
		case 1: 
			//1. We print the empty message
			System.out.println("Empty MyList");
			
			break;
			
		//Rule 2. MyList is non-empty
		case 2: 
			//1. We print the initial message
			int size = m.length();
			System.out.println("MyList Contains the following " + size + " items: ");
			
			//2. We traverse the items
			for (int i = 0; i < size; i++)
				System.out.println("Item " + i + ": " + m.getElement(i));
			
			break;
	
		}
		
	}

	//-------------------------------------------------------------------
	// 1. recursiveDisplayElements --> Displays all elements of a MyList  
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this recursive algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void recursiveDisplayElements(MyList<Integer> m){

		if (m == null || m.length() == 0)
			System.out.println("\nMyList Contains No Elements");
			
		else if (m.length() == 1)
			System.out.println("\nMyList Contains the following items:\nItem: " + m.getElement(0));
		
		else {
			
			int element = m.getElement(m.length()-1);
			m.removeElement(m.length()-1);
			recursiveDisplayElements(m);
			m.addElement(m.length(), element);
			
			System.out.println("Item: " + element);
		}
			
	}

	//-------------------------------------------------------------------
	// 2. smallerMyList --> Filters all elements in MyList smaller than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyList being smaller than 'e'  
	 * @param m: The MyList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyList to.
	 * @return: The new MyList containing just the elements being smaller than 'e'  
	 */	
	public MyList<Integer> smallerMyList(MyList<Integer> m, int e){
		
		MyList<Integer> result = new MyDynamicList<Integer>();
		
		if (m != null && m.length() != 0) {
			
			int element = m.getElement(0);
			m.removeElement(0);
			result = smallerMyList(m, e);
			m.addElement(0, element);
			
			if (element < e)
				result.addElement(0, element);
		}
		
		return result;
	}

	//-------------------------------------------------------------------
	// 3. biggerMyList --> Filters all elements in MyList bigger than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyList being bigger than 'e'  
	 * @param m: The MyList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyList to.
	 * @return: The new MyList containing just the elements being bigger or equal than 'e'  
	 */	
	public MyList<Integer> biggerEqualMyList(MyList<Integer> m, int e){

		MyList<Integer> result = new MyDynamicList<Integer>();
		
		if (m != null && m.length() != 0) {
			
			int element = m.getElement(0);
			m.removeElement(0);
			result = biggerEqualMyList(m, e);
			m.addElement(0, element);
			
			if (element >= e)
				result.addElement(0, element);
		}
		
		return result;
	}
		
	//-------------------------------------------------------------------
	// 3. concatenate --> It concatenates 2 MyList   
	//-------------------------------------------------------------------	
	/**
	 * The function concatenates the content of 2 MyList.   
	 * @param m1: The first MyList.
	 * @param m2: The second MyList.
	 * @return: The new MyList resulting of concatenate the other 2 MyList
	 */	
	public MyList<Integer> concatenate(MyList<Integer> m1, MyList<Integer> m2){

		MyList<Integer> result = new MyDynamicList<Integer>();

		if (m1 != null && m1.length() != 0) {
			
			int element = m1.getElement(0);
			m1.removeElement(0);
			result = concatenate(m1, m2);
			m1.addElement(0, element);
			
			result.addElement(0, element);
		}
			
		else if (m2 != null && m2.length() != 0) {

			int element = m2.getElement(0);
			m2.removeElement(0);
			result = concatenate(m1, m2);
			m2.addElement(0, element);
			
			result.addElement(0, element);
		}
		
		return result;	
	}
	
	//-------------------------------------------------------------------
	// 4. quickSort --> Sort a MyList using the method quick sort
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, it computes a new sorted list using the method Quick Sort.
	 * @param m: The MyList we want to sort.
	 * @return: The new MyList being sorted.	  	  
	 */	 
	public MyList<Integer> quickSort(MyList<Integer> m){
		
		if(m == null || m.length() == 0)
			return new MyDynamicList<Integer>();
		
		else if(m.length() == 1) {
			
			MyList<Integer> m1 = new MyDynamicList<Integer>();
			m1.addElement(0, m.getElement(0));
			return m1;
		}
		
		else {
			
			int element = m.getElement(0);
			m.removeElement(0);
			
			MyList<Integer> m1 = smallerMyList(m, element);
			MyList<Integer> m2 = biggerEqualMyList(m, element);
			
			m1 = quickSort(m1);
			m2 = quickSort(m2);
			
			m.addElement(0, element);
			
			m2.addElement(0, element);
			return concatenate(m1, m2);
		}	
	}
	
}
