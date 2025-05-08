package A2Z.step3_Arrays.lec1_Easy;

import java.util.HashMap;

/*
Given an array and a sum k, we need to print the length of the longest subarray that sums to k.

Examples

Example 1:
Input Format: N = 3, k = 5, array[] = {2,3,5}
Result: 2
Explanation: The longest subarray with sum 5 is {2, 3}. And its length is 2.

Example 2:
Input Format: N = 3, k = 1, array[] = {-1, 1, 1}
Result: 3
Explanation: The longest subarray with sum 1 is {-1, 1, 1}. And its length is 3.


*/

public class LongestSubarraySumWithKNegative {
    public static void main(String[] args) {
        int[] arr= {-1, 1, 1};
        int n=arr.length;
        int k=1;
        //using hashing
        HashMap<Integer,Integer> preSumMap=new HashMap<>();
        int sum=0;
        int maxLen=0;
        for(int i=0;i<n;i++){
            sum=sum+arr[i];
            if(sum==k){
                maxLen=Math.max(maxLen,i+1);
            }
            int rem=sum-k;
            if(preSumMap.containsKey(rem)){
                int len=i-preSumMap.get(rem);
                maxLen=Math.max(maxLen,len);
            }
            if (preSumMap.containsKey(sum)==false){
                preSumMap.put(sum,i);
            }
        }
        System.out.println(maxLen);
        //3
    }
}
