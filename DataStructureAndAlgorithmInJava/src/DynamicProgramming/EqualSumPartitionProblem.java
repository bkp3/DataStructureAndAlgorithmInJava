package DynamicProgramming;
/*

4
1 5 11 5
True

*/

import java.util.Scanner;

public class EqualSumPartitionProblem {

    private static int N;
    private static int[] arr;

    public EqualSumPartitionProblem(int n){
        this.N=n;
        arr=new int[N];
    }

    public boolean fun(){

        int SUM = 0;
        for(int i=0;i<N;i++){
            SUM=SUM+arr[i];
        }
        if(SUM%2 != 0)
            return false;

        SUM = SUM/2;
        boolean[][] dp = new boolean[N+1][SUM+1];

        for(int i=0;i<N+1;i++){
            for(int j=0;j<SUM+1;j++){
                if(i==0)
                    dp[i][j]=false;
                else if(j==0)
                    dp[i][j]=true;
                else if(arr[i-1]<=j)
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-arr[i-1]];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[N][SUM];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        EqualSumPartitionProblem obj = new EqualSumPartitionProblem(n);
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        boolean ans = obj.fun();
        System.out.println(ans);
    }

}
