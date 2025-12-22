import java.util.*;
public class ArrayOperations {
	static Scanner sc = new Scanner(System.in);
	static int arr[]  = new int[50];
	static int size =0;

	public static void main(String[] args) {
		
		int choice;

        do {
            System.out.println("\n===== ARRAY OPERATIONS MENU =====");
            System.out.println("1. Insert Element");
            System.out.println("2. Delete Element");
            System.out.println("3. Linear Search");
            System.out.println("4. Binary Search");
            System.out.println("5. Find Maximum Value");
            System.out.println("6. Count Even and Odd");
            System.out.println("7. Insertion Sort");
            System.out.println("8. Display Array");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: insertElement(); break;
                case 2: deleteElement(); break;
                case 3: linearSearch(); break;
                case 4: binarySearch(); break;
                case 5: maximumElement(); break;
                case 6: countEvenOdd(); break;
                case 7: insertionSort(); break;
                case 8: displayArray(); break;
                case 0: System.out.println("Program terminated."); break;
                default: System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }
       

     //insert method 
     public static void insertElement() {
    	System.out.println("Enter a Size : ");
    	size = sc.nextInt();
    	for(int i=0; i<size; i++) {
    		arr[i]=sc.nextInt();
    	}
     }
     
     // delete method 
     public static void deleteElement() {
    	 System.out.print("Enter element to delete: ");
    	 int key = sc.nextInt();
    	 int index =-1;
    	 for(int i=0; i<size; i++) {
    		 if(arr[i]==key) {
    			 index = i;
    			 break;
    		 }
    	 }
    	 if (index == -1) {
             System.out.println("Element not found.");
             return;
         }

         for (int i = index; i < size - 1; i++) {
             arr[i] = arr[i + 1];
         }
         size--;
     }
     
     
     // linear search 
     public static void linearSearch() {
    	 
    	 System.out.println("Enter the number to search : ");
    	 int target = sc.nextInt();
    	 for(int i=0; i<size; i++) {
    		 if(arr[i]==target) {
    			 System.out.print("Element Found " +i);
    			 return;
    		 } 		 
    	 }
    	 System.out.println("Not Found !");
     }
     
     
     //  Performs binary search (array must be sorted)
     public static void binarySearch() {
    	 //insertionSort();
    	 System.out.print("Enter element to search: ");
         int target = sc.nextInt();
         
         int low =0 , high = size-1;
         while(low<high) {
        	 int mid = (low+high)/2;
        	 if(arr[mid] == target) {System.out.println("Element Found : "+mid);
        	 return;
        	 }
        	 else if(target<arr[mid]) {
        		 high = mid-1;
        	 }
        	 else {
        		 low = mid+1;
        	 }
         }
         System.out.println("Not Found!");
     }
     
     // Finds the maximum element
     public static void maximumElement() {
    	 int max = arr[0];
    	 for(int i=0; i<size; i++) {
    		 if(arr[i]>max) {
    			 max = arr[i];
    		 }
    	 }
    	 System.out.println("Maximum Element: "+max);
     }
     
     
     //count EvenOdd
     public static void countEvenOdd() {
    	 int evenCount =0;
    	 int oddCount = 0;
    	 for(int i=0; i<size; i++) {
    		 if(arr[i]%2==0)evenCount++;
    		 else oddCount++;
    	 }
    	 System.out.println("Even Count : "+evenCount + "  Odd Count : "+oddCount);
     }
     
     // Sorts the array using insertion sort
     public static void insertionSort() {
    	 for (int i = 1; i < size; i++) {
             int key = arr[i];
             int j = i - 1;
             while (j >= 0 && arr[j] > key) {
                 arr[j + 1] = arr[j];
                 j--;
             }
             arr[j + 1] = key;
         }
     }
     
     
     static void displayArray() {
         if (size == 0) {
             System.out.println("Array is empty.");
             return;
         }
         for (int i = 0; i < size; i++)
             System.out.print(arr[i] + " ");
         System.out.println();
     }
}
