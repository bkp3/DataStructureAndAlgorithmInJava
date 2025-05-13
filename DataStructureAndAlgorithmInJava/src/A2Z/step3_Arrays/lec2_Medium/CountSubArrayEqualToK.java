package A2Z.step3_Arrays.lec2_Medium;

/*
Given an array of integers and an integer k, return the total number of subarrays whose sum equals k.

A subarray is a contiguous non-empty sequence of elements within an array.

Pre-requisite: Longest subarray with given sum

Examples

Example 1:
Input Format: N = 4, array[] = {3, 1, 2, 4}, k = 6
Result: 2
Explanation: The subarrays that sum up to 6 are [3, 1, 2] and [2, 4].

Example 2:
Input Format: N = 3, array[] = {1,2,3}, k = 3
Result: 2
Explanation: The subarrays that sum up to 3 are [1, 2], and [3].


*/

import java.util.HashMap;

public class CountSubArrayEqualToK {
    public static void main(String[] args) {
        int[] arr={3,1,2,4};
        int k=6;
        int n=arr.length;

        //brute : 3 for loops
        int cnt1=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum=0;
                for(int l=i;l<=j;l++){
                    sum=sum+arr[l];
                }
                if(sum==k){
                    cnt1++;
                }
            }
        }
        System.out.println(cnt1);
        //2

        //Better : 2 for loops
        int cnt2=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum=sum+arr[j];
                if(sum==k){
                    cnt2++;
                }
            }
        }
        System.out.println(cnt2);
        //2

        //optimal : prefix sum - map
        HashMap<Integer,Integer>mp=new HashMap<>();
        int cnt3=0;
        int preSum=0;
        mp.put(0,1);
        for(int i=0;i<n;i++){
            preSum=preSum+arr[i];
            int rem=preSum-k;
            if(mp.containsKey(rem))
                cnt3=cnt3+mp.get(rem);
            else
                mp.put(rem,1);
            if(mp.containsKey(preSum))
                mp.put(preSum,mp.get(preSum)+1);
            else mp.put(preSum,1);
        }
        System.out.println(cnt3);
        //2
    }
}
