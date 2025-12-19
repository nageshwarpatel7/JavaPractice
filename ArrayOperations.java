import java.util.*;
public class ArrayOperations {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[10];
		int n = 0, choice;
		
		
        do {
        	System.out.println("\n--- MENU ---");
		    System.out.println("1. Insert element");
		    System.out.println("2. Delete element");
		    System.out.println("3. Linear search");
		    System.out.println("4. Binary search");
		    System.out.println("5. Find maximum");
		    System.out.println("6. Count even and odd");
		    System.out.println("7. Insertion sort");
		    System.out.println("8. Display array");
		    System.out.println("9. Exit");

		    System.out.print("Enter choice: ");
		    choice = sc.nextInt();

		    switch (choice) {
		    	case 1: // Insert
		    		if(n==10) {
		    			System.out.println("Array maximum limit reached");
		    			break;
		    		}
		    		System.out.print("Enter element: ");
		            arr[n] = sc.nextInt();
		            n++;
		            break;

		    	case 2: // Delete
		    		System.out.print("Enter element to delete: ");
		            int del = sc.nextInt();

		            for (int i = 0; i < n; i++) {
		            	if (arr[i] == del) {
		            		for (int j = i; j < n - 1; j++) {
		                          arr[j] = arr[j + 1];
		                    }
		                    n--;
		                    break;
		                    }
		             }
		             break;

		         case 3: // Linear search
		             System.out.print("Enter element to search: ");
		             int key = sc.nextInt();

		             for (int i = 0; i < n; i++) {
		                 if (arr[i] == key) {
		                    System.out.println("Element found at position " + i);
		                    break;
		                 }
		             }
		             break;

		         case 4: // Binary search (assumes sorted array)
		             System.out.print("Enter element to search: ");
		             key = sc.nextInt();
		             int low = 0, high = n - 1;

		             while (low <= high) {
		                int mid = (low + high) / 2;

		                if (arr[mid] == key) {
		                    System.out.println("Element found");
		                    break;
		                } else if (arr[mid] < key) {
		                    low = mid + 1;
		                } else {
		                      high = mid - 1;
		                }
		             }
		             break;

		         case 5: // Maximum
		        	 int max = arr[0];
		             for (int i = 1; i < n; i++) {
		            	 if (arr[i] > max)
		                     max = arr[i];
		                 }
		                 System.out.println("Maximum value = " + max);
		                 break;

		         case 6: // Even / Odd count
		               int even = 0, odd = 0;
		               for (int i = 0; i < n; i++) {
		            	   if (arr[i] % 2 == 0)
		            		   even++;
		                   else
		                       	odd++;
		                    }
		                    System.out.println("Even = " + even);
		                    System.out.println("Odd = " + odd);
		                    break;

		                case 7: // Insertion sort
		                    for (int i = 1; i < n; i++) {
		                        int temp = arr[i];
		                        int j = i - 1;

		                        while (j >= 0 && arr[j] > temp) {
		                            arr[j + 1] = arr[j];
		                            j--;
		                        }
		                        arr[j + 1] = temp;
		                    }
		                    System.out.println("Array sorted");
		                    break;

		                case 8: // Display
		                    System.out.print("Array elements: ");
		                    for (int i = 0; i < n; i++) {
		                        System.out.print(arr[i] + " ");
		                    }
		                    System.out.println();
		                    break;

		                case 9:
		                    System.out.println("Exit");
		                    break;

		                default:
		                    System.out.println("Invalid choice");
		            }
        } while (choice != 9);

        sc.close();
	}
}
