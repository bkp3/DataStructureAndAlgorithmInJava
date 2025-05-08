package A2Z.step3_Arrays.lec1_Easy;
/*
Given a non-empty array of integers arr, every element appears twice except for one. Find that single one.

Examples

Example 1:
Input Format: arr[] = {2,2,1}
Result: 1
Explanation: In this array, only the element 1 appear once and so it is the answer.




*/

public class FindSingleElement {

    public static void main(String[] args) {
        int[] arr={1,1,2,3,3,4,4,5,5};
        int n=arr.length;
        int xor=0;
        for(int i=0;i<n;i++){
            xor=xor^arr[i];
        }
        System.out.println(xor);
        //2
    }
}
