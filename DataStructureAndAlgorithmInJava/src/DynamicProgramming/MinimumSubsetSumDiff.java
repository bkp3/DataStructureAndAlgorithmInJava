package DynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;
/*

3
1 2 7
4
*/

public class MinimumSubsetSumDiff {

    private static int N;
    private static int[] arr;

    MinimumSubsetSumDiff(int n){
        this.N=n;
        arr= new int[N];
    }

    public int fun(){
        int range=0;
        for(int i=0;i<N;i++){
            range=range+arr[i];
        }

        boolean[][] dp = new boolean[N+1][range+1];

        for (int i = 0; i <= N; i++)
            dp[i][0] = true;

        for (int i = 1; i <= range; i++)
            dp[0][i] = false;

        for(int i=1;i<N+1;i++){
            for(int j=1;j<range+1;j++){
                if(arr[i-1]<=j)
                    dp[i][j]=dp[i-1][j-arr[i-1]];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }

        int diff = Integer.MAX_VALUE;
        for (int j = range / 2; j >= 0; j--)
        {
            if (dp[N][j] == true)
            {
                diff = range - 2 * j;
                break;
            }
        }
        return diff;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        MinimumSubsetSumDiff obj = new MinimumSubsetSumDiff(n);
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int ans= obj.fun();
        System.out.println(ans);
    }
}
