package A2Z.step3_Arrays.lec3_Hard;

/*
Given an array containing both positive and negative integers, we have to find the length of the longest subarray with the sum of all elements equal to zero.

Examples

Example 1:
Input Format: N = 6, array[] = {9, -3, 3, -1, 6, -5}
Result: 5
Explanation: The following subarrays sum to zero:
{-3, 3} , {-1, 6, -5}, {-3, 3, -1, 6, -5}
Since we require the length of the longest subarray, our answer is 5!


*/

import java.util.HashMap;

public class LargestSubarrayWithZeroSum {

    public static void main(String[] args) {
        int[] arr={9, -3, 3, -1, 6, -5};
        int n=arr.length;

        //Brute : O(n^3)
        //Better : O(n^2)

        //Optimal : Hashmap + prefix sum
        HashMap<Integer,Integer>mp=new HashMap<>();
        int maxi=0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+arr[i];
            if(sum==0){
                maxi=i+1;
            }else{
                if(mp.get(sum)!=null){
                    maxi=Math.max(maxi,i-mp.get(sum));
                }else{
                    mp.put(sum,i);
                }
            }
        }
        System.out.println(maxi);
        //5
    }

}
