package SDE_ArraysI;

import java.util.ArrayList;
import java.util.List;

/*
Problem Statement: This problem has 3 variations. They are stated below:

Variation 1: Given row number r and column number c. Print the element at position (r, c) in Pascal’s triangle.

Variation 2: Given the row number n. Print the n-th row of Pascal’s triangle.

Variation 3: Given the number of rows n. Print the first n rows of Pascal’s triangle.


Input Format:
 N = 5, r = 5, c = 3
Result:
 6 (for variation 1)
1 4 6 4 1 (for variation 2)

1 
1 1 
1 2 1 
1 3 3 1 
1 4 6 4 1    (for variation 3)



The element at position (r,c) is: 6
1 4 6 4 1 
1 
1 1 
1 2 1 
1 3 3 1 
1 4 6 4 1 


*/
public class PascalTriangle {
	
	public static long nCr(int n, int r) {
        long res = 1;

        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    public static int pascalTriangleElement(int r, int c) {
        int element = (int) nCr(r - 1, c - 1);
        return element;
    }
    
    
    static void pascalTriangleRow(int n) {
        long ans = 1;
        System.out.print(ans + " "); // printing 1st element

        // Printing the rest of the part:
        for (int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / i;
            System.out.print(ans + " ");
        }
        System.out.println();
    }
    
    

    public static List<List<Integer>> pascalTriangle(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        // Store the entire Pascal's triangle:
        for (int row = 1; row <= n; row++) {
            List<Integer> tempLst = new ArrayList<>(); // temporary list
            for (int col = 1; col <= row; col++) {
                tempLst.add((int)nCr(row - 1, col - 1));
            }
            ans.add(tempLst);
        }
        return ans;
    }
    
	
	

	public static void main(String[] args) {
		
		//var 1
		int r = 5; // row number
        int c = 3; // col number
        int element = pascalTriangleElement(r, c);
        System.out.println("The element at position (r,c) is: " + element);
        
        //var 2
        int n = 5;
        pascalTriangleRow(n);
        
        
        //var 3
        List<List<Integer>> ans = pascalTriangle(n);
        for (List<Integer> it : ans) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
		

	}

}
