package DynamicProgramming;
import java.util.*;
/*

3
10 20 30
10 100 120
50

220

*/

public class KnapsackRec {

    static int maxFun(int a,int b){
        return a>b?a:b;
    }

    static int knapsack(int wt[],int val[],int W,int n){
        if(n==0 || W==0)
            return 0;

        if(wt[n-1]>W)
            return knapsack(wt,val,W,n-1);
        else
            return maxFun((val[n-1]+knapsack(wt,val,W-wt[n-1],n-1)),knapsack(wt,val,W,n-1));
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int wt[]=new int[n];
        for(int i=0;i<n;i++){
            wt[i]=sc.nextInt();
        }
        int val[]=new int[n];
        for(int i=0;i<n;i++){
            val[i]=sc.nextInt();
        }
        int W=sc.nextInt();
        System.out.println(knapsack(wt,val,W,n));


    }

}
