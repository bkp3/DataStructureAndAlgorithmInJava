package DynamicProgramming;
import java.util.*;

/*

3
50
10 20 30
10 100 120

220

*/

public class KnapsackTopDownApproach {
    private static int N,W;
    private static int[] wt;
    private static int[] val;
    private static int[][] dp;

    public KnapsackTopDownApproach(int n,int w){
        this.N=n;
        this.W=w;
        wt=new int[N];
        val=new int[N];
        dp = new int[N+1][W+1];
    }

    public int knapsack(){
        for(int i=0;i<N+1;i++){
            for(int j=0;j<W+1;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }else if(wt[i-1]<=j){
                    dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                }else if(wt[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[N][W];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int W=sc.nextInt();
        KnapsackTopDownApproach obj = new KnapsackTopDownApproach(n,W);
        for(int i=0;i<n;i++){
            wt[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            val[i]=sc.nextInt();
        }

        int ans= obj.knapsack();
        System.out.println(ans);

    }

}
