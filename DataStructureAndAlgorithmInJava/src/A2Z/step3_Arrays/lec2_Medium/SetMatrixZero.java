package A2Z.step3_Arrays.lec2_Medium;
/*
Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 and then return the matrix.

Examples
Examples 1:

Input: matrix=[[1,1,1],[1,0,1],[1,1,1]]

Output: [[1,0,1],[0,0,0],[1,0,1]]

Explanation: Since matrix[2][2]=0.Therfore the 2nd column and 2nd row wil be set to 0.


*/

public class SetMatrixZero {

    static void funBetter(int[][] mat,int n,int m){
        int[] col=new int[m];
        int[] row=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(row[i]==1||col[j]==1){
                    mat[i][j]=0;
                }
            }
        }
    }

    static void funOptimal(int[][] mat,int n,int m){
        int col0=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    mat[i][0]=0;
                    if(j!=0){
                        mat[0][j]=0;
                    }else {
                        col0=0;
                    }
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]!=0){
                    if(mat[0][j]==0||mat[i][0]==0){
                        mat[i][j]=0;
                    }
                }
            }
        }
        if(col0==0){
            for (int i = 0; i < n; i++) {
                mat[i][0]=0;

            }
        }
    }

    public static void main(String[] args) {
        int[][] mat={{1,1,1},{1,0,1},{1,1,1}};
        int n=mat.length;
        int m=mat[0].length;
        //brute : O(n^3) : -1 approach

        //better : using row & col array

//        funBetter(mat,n,m);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }

        //optimal : inside mat row & col array
        funOptimal(mat,n,m);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }

    }

}
