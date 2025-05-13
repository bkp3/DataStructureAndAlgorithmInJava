package A2Z.step3_Arrays.lec2_Medium;
/*

 Given a matrix, your task is to rotate the matrix 90 degrees clockwise.

Note: Rotate matrix 90 degrees anticlockwise

Examples
Example 1:

Input: [[1,2,3],[4,5,6],[7,8,9]]

Output: [[7,4,1],[8,5,2],[9,6,3]]

Explanation: Rotate the matrix simply by 90 degree clockwise and return the matrix.

*/

public class RotateMatrixBy90Degree {
    static int[][] funBrute(int[][] mat,int n){
        int[][] ans=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][n-i-1]=mat[i][j];
            }
        }
        return ans;
    }
    static void funOptimal(int[][] mat,int n){
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j <n ; j++) {
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for(int j=0;j<n/2;j++){
                int tmp=mat[i][j];
                mat[i][j]=mat[i][n-j-1];
                mat[i][n-j-1]=tmp;
            }
        }

    }
    public static void main(String[] args) {
        int[][] mat={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int n=mat.length;


        //brute :storing in another matrix;
        int[][] ans=funBrute(mat,n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }

        //optimal : 1. transpose, 2. reverse
        funOptimal(mat,n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        /*

13 9 5 1
14 10 6 2
15 11 7 3
16 12 8 4

        */
    }
}
