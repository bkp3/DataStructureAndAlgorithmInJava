package A2Z.step1_LearnTheBasics.lec5_BasicRecursion;

import java.util.Arrays;
/*

You are given an array. The task is to reverse the array and print it.

Examples:

Example 1:
Input: N = 5, arr[] = {5,4,3,2,1}
Output: {1,2,3,4,5}
Explanation: Since the order of elements gets reversed the first element will occupy the fifth position, the second element occupies the fourth position and so on.


*/

public class ReverseAnArray {

    static void swap(int l,int r,int[] arr){
        int tmp=arr[l];
        arr[l]=arr[r];
        arr[r]=tmp;
    }

    static void funTwoPointer(int l,int r,int[] arr){
        if(l>=r){
            return;
        }
        swap(l,r,arr);
        funTwoPointer(l+1,r-1,arr);
    }

    static void funSinglePointer(int i,int[] arr){
        if(i>=arr.length-i-1){
            return;
        }
        swap(i, arr.length-i-1,arr);
        funSinglePointer(i+1,arr);
    }

    public static void main(String[] args) {
        int n=5;
        int[] arr={5,4,3,2,1};
        Arrays.stream(arr).forEach(x-> System.out.print(x+" "));
        //5 4 3 2 1
        System.out.println();

        //using two pointer
        funTwoPointer(0,n-1,arr);
        Arrays.stream(arr).forEach(x-> System.out.print(x+" "));
        //1 2 3 4 5
        System.out.println();

        arr= new int[]{5, 4, 3, 2, 1};
        //using single pointer
        funSinglePointer(0,arr);
        Arrays.stream(arr).forEach(x-> System.out.print(x+" "));
        //1 2 3 4 5

    }
}
