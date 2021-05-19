package DynamicProgramming;

import java.util.Scanner;
/*

6 10
2 3 5 6 8 10
3

*/

public class CountOfSubsetSumWithGivenSum {

    private static int N,SUM;
    private static int[] arr;
    private static int[][] dp;

    public CountOfSubsetSumWithGivenSum(int n,int sum){
        this.N=n;
        this.SUM=sum;
        arr = new int[N];
        dp = new int[N+1][SUM+1];
    }

    public int countOfSubset(){
        for(int i=1;i<N+1;i++){
            for(int j=1;j<SUM+1;j++){
                if(i==0)
                    dp[i][j]=0;
                else if(j==0)
                    dp[i][j]=1;
                else if(arr[i-1]<=j)
                    dp[i][j]=dp[i-1][j] + dp[i-1][j-arr[i-1]];
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
        CountOfSubsetSumWithGivenSum obj = new CountOfSubsetSumWithGivenSum(n,sum);
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int ans= obj.countOfSubset();
        System.out.println(ans);
    }
}
