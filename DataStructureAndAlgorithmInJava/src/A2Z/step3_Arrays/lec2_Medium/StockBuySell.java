package A2Z.step3_Arrays.lec2_Medium;
/*
You are given an array of prices where prices[i] is the price of a given stock on an ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Examples
Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and
sell on day 5 (price = 6), profit = 6-1 = 5.

Note: That buying on day 2 and selling on day 1
is not allowed because you must buy before
you sell.


*/

public class StockBuySell {
    public static void main(String[] args) {
        int[] arr={7,1,5,3,6,4};
        int n=arr.length;
        int mini=arr[0];
        int profit=0;
        for(int i=0;i<n;i++){
            int cost=arr[i]-mini;
            profit=Math.max(cost,profit);
            mini=Math.min(mini,arr[i]);
        }
        System.out.println(profit);
        //5
    }
}
