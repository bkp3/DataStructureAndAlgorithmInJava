package A2Z.step3_Arrays.lec1_Easy;

import java.util.HashMap;

/*

Given an array and a sum k, we need to print the length of the longest subarray that sums to k.

Examples

Example 1:
Input Format: N = 3, k = 5, array[] = {2,3,5}
Result: 2
Explanation: The longest subarray with sum 5 is {2, 3}. And its length is 2.


*/

public class LongestSubarraySumWithK {
    public static void main(String[] args) {
        int[] arr={2,3,5,1,9};
        int k=10;
        int n=arr.length;

        int left=0;
        int right=0;
        int sum=arr[0];
        int maxLen=0;


        while(right<n){
            while(left<=right && sum>k){
                sum=sum-arr[left];
                left++;
            }
            if(sum==k){
                maxLen=Math.max(maxLen,right-left+1);
            }
            right++;
            if(right<n){
                sum=sum+arr[right];
            }
        }
        System.out.println(maxLen);
        //3

    }
}
