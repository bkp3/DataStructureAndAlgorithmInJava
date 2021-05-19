package DynamicProgramming;

import java.util.Scanner;

/*

5 11
2 3 7 8 10
true

*/

public class SubsetSumProblem {
    private static int N,SUM;
    private static int[] arr;
    private static boolean[][] dp;

    public SubsetSumProblem(int n,int sum){
        this.N=n;
        this.SUM=sum;
        arr = new int[N];
        dp = new boolean[N+1][SUM+1];
    }

    public boolean subsetSum(){
        for(int i=0;i<N+1;i++){
            for(int j=0;j<SUM+1;j++){
                if(i==0)
                    dp[i][j]=false;
                else if(j==0)
                    dp[i][j]=true;
                else if(arr[i-1]<=j)
                    dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[N][SUM];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int sum=sc.nextInt();
        SubsetSumProblem obj = new SubsetSumProblem(n,sum);
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        boolean ans= obj.subsetSum();
        System.out.println(ans);

    }
}
