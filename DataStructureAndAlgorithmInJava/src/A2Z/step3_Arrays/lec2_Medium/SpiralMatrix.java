package A2Z.step3_Arrays.lec2_Medium;
/*
Given a Matrix, print the given matrix in spiral order.

Examples:

Example 1:
Input: Matrix[][] = { { 1, 2, 3, 4 },
		      { 5, 6, 7, 8 },
		      { 9, 10, 11, 12 },
	              { 13, 14, 15, 16 } }

Outhput: 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10.
Explanation: The output of matrix in spiral form.


*/

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] mat={ { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        int n=mat.length;
        int m=mat[0].length;
        int left=0;
        int top=0;
        int right=m-1;
        int bottom=n-1;
        List<Integer>list=new ArrayList<>();
        while(top<=bottom && left<=right){
            for (int i = left; i <=right ; i++) {
                list.add(mat[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                list.add(mat[i][right]);
            }
            right--;
            if(top<=bottom){
                for (int i = right; i >=left ; i--) {
                    list.add(mat[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for (int i = bottom; i >=top ; i--) {
                    list.add(mat[i][left]);
                }
                left++;
            }
        }
        System.out.println(list);
//        [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
    }
}
