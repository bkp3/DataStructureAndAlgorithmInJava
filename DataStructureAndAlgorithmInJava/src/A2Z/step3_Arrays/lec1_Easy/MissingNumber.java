package A2Z.step3_Arrays.lec1_Easy;
/*
Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N. Find the number(between 1 to N), that is not present in the given array.

Examples

Example 1:
Input Format: N = 5, array[] = {1,2,4,5}
Result: 3
Explanation: In the given array, number 3 is missing. So, 3 is the answer.



*/

public class MissingNumber {
    public static void main(String[] args) {
        //other optimal : sum solution


        int[] arr={1,2,3,5};
        int n=arr.length;
        int xor1=0;
        int xor2=0;
        for(int i=0;i<n;i++){
            xor1=xor1^arr[i];
            xor2=xor2^(i+1);
        }
        xor2=xor2^(n+1);
        System.out.println(xor1^xor2);
        //4
    }
}
