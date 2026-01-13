package assignment3;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemonstrate {

	public static void main(String[] args) {
		
		ArrayList<Integer> arr = new ArrayList<>();
		arrayInt(arr);
		

	}
	
	// operations :
	
	public static void arrayInt(ArrayList<Integer> arr) {
		Scanner sc  = new Scanner(System.in);
		//Insertion Single 
		System.out.println(arr.add(10)); // boolean return 
	    System.out.println(arr);
	    
	    System.out.println("Enter the 5 Elements : ");
	    // Multiple Insertion (5 elements)
	    for(int i =0; i<5; i++) {
	    	arr.add(sc.nextInt());
	    }
	    
	    // Overloaded method -- > void
	    arr.add(2,201);
	    
	    
	    // Print line by line
	    for(Integer ele : arr) {
	    	System.out.println("Element is "+ele);
	    }
	    
	    // Returns the element at the specified position in this list.
	    System.out.println("Element at index 1: "+arr.get(1));
	    
	    // Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
	    int index = arr.indexOf(201);
	    System.out.println(index);
	   
	    //Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
	    System.out.println(arr.lastIndexOf(2));
	    
	    
	    // Returns true if this list contains no elements.
	    System.out.println(arr.isEmpty());
	    
	   // Removes the element at the specified position in this list.
	    arr.remove(3);
	    
	    //Removes all of the elements of this collection that satisfy the given predicate.
	   
	    // Returns the number of elements in this list.
	     System.out.println(arr.size());	    
	    
	    // Clear()
	    arr.clear();
	    
	}

}