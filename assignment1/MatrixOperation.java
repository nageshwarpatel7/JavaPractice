package assignment1;
import java.util.Scanner;

public class MatrixOperation {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		 System.out.print("Enter number of rows: ");
	        int r = sc.nextInt();
	        System.out.print("Enter number of columns: ");
	        int c = sc.nextInt();

	        int[][] arr = new int[r][c];
	        int[][] brr = new int[r][c];
      
	        System.out.println("Enter the Elements in 1st Matrix : ");
	        inputMatrix(arr);
	        
	        System.out.println("Enter the elements of 2nd Matrix : ");
	        inputMatrix(brr);
	        
	        System.out.println("Choose the option to : ");
	        // option for perform opertions on matrix :
	        display();
	        int choice = sc.nextInt();
	        
	        switch(choice){
	        case 1: matrixAddition(arr,brr); break;
	        case 2: matrixSubstraction(arr,brr); break ;
	        case 3: matrixMulti (arr,brr); break;
	        case 4: TransposeMatrix(arr);  break;
	        case 5: isDiagonal(arr,r,c);   break;
	        case 6: isIdentity(arr,r,c);  break;
	        case 7: return;	
	        }
	       
	        
	        
	}
	
	public static void inputMatrix(int arr[][]) {
		int row = arr.length;
		int col = arr[0].length;
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
	}
	
	public static void outputMatrix(int arr[][]) {
		int row = arr.length;
		int col = arr[0].length;
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				System.out.print(arr[i][j]+" ");
			}
		}
	}
	
	public static void display() {
		System.out.println("  **********************  Matrix Dashboard  ****************");
		System.out.println("Choose the option to perform Opertions : ");
		System.out.println("1. Matrix Addition        : Press 1 ");
		System.out.println("2. Matrix Substraction    : Press 2 ");
		System.out.println("3. Matrix Multiplication  : Press 3 ");
		System.out.println("4. Matrix Transpose       : Press 4 ");
		System.out.println("5. Check Daigonal         : Press 5 ");
		System.out.println("6. Check Identity         : Press 6 ");
		System.out.println("7. Exit                   : Press 0 ");
		System.out.print("Press key  : ");	
	}
	
	// Addition method 
	public static void matrixAddition(int[][] arr, int[][] brr) {
		int row = arr.length;
		int col = arr[0].length;
		int[][] add = new int[row][col];
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
		          add[i][j]=arr[i][j]+brr[i][j];		
			}
		}
		outputMatrix(add);
	}
	
	// Substraction method 
	public static void matrixSubstraction(int[][] arr, int[][] brr) {
		int row = arr.length;
		int col = arr[0].length;
		int[][] sub = new int[row][col];
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
		          sub[i][j]=arr[i][j]-brr[i][j];		
			}
		}
		outputMatrix(sub);
	}
	
	
	public static void matrixMulti(int[][] arr, int[][] brr) {

	    int r1 = arr.length;
	    int c1 = arr[0].length;
	    int c2 = brr[0].length;

	    int[][] mul = new int[r1][c2];

	    for (int i = 0; i < r1; i++) {
	        for (int j = 0; j < c2; j++) {
	            for (int k = 0; k < c1; k++) {
	                mul[i][j] += arr[i][k] * brr[k][j];
	            }
	        }
	    }

	    outputMatrix(mul);
	}
	
		
	 // Transpose of Matrix 
		public static void TransposeMatrix(int[][] arr) {
			int row = arr.length;
			int col = arr[0].length;
			int[][] T = new int[col][row];
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
			        T[i][j]=arr[i][j];
				}
			}
			outputMatrix(T);
			
		}
	
		// Check square matrix
	    static boolean isSquare(int r, int c) {
	        return r == c;
	    }
	    
	    
	    // Check diagonal matrix
	    static boolean isDiagonal(int[][] arr, int r, int c) {
	        if (r != c) return false;

	        for (int i = 0; i < r; i++)
	            for (int j = 0; j < c; j++)
	                if (i != j && arr[i][j] != 0)
	                    return false;

	        return true;
	    }
	    
	    // Check identity matrix
	    static boolean isIdentity(int[][] arr, int r, int c) {
	        if (r != c) return false;

	        for (int i = 0; i < r; i++)
	            for (int j = 0; j < c; j++) {
	                if (i == j && arr[i][j] != 1)
	                    return false;
	                if (i != j && arr[i][j] != 0)
	                    return false;
	            }
	        return true;
	    }
}
