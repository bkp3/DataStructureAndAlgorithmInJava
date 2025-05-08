package A2Z.step3_Arrays.lec1_Easy;
/*
Given an array that contains only 1 and 0 return the count of maximum consecutive ones in the array.

Examples:

Example 1:

Input: prices = {1, 1, 0, 1, 1, 1}

Output: 3

Explanation: There are two consecutive 1’s and three consecutive 1’s in the array out of which maximum is 3.



*/

public class MaximumConsecutiveOne {
    public static void main(String[] args) {
        int[] arr={1,1,0,1,1,1,0,1,1};
        int n=arr.length;
        int maxi=0;
        int cnt=0;
        for(int i=0;i<n;i++){
            if(arr[i]==1){
                cnt++;
                maxi=Math.max(cnt,maxi);
            }else{
                cnt=0;
            }
        }
        System.out.println(maxi);
        //3
    }
}
