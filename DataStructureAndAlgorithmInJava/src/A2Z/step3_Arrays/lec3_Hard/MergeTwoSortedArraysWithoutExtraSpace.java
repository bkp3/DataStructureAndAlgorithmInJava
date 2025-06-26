package A2Z.step3_Arrays.lec3_Hard;
/*

Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted order. Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.

Examples

Example 1:

Input:
n = 4, arr1[] = [1 4 8 10]
m = 5, arr2[] = [2 3 9]

Output:
arr1[] = [1 2 3 4]
arr2[] = [8 9 10]

Explanation:
After merging the two non-decreasing arrays, we get, 1,2,3,4,8,9,10.


*/

import Array.Array;

import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpace {

    public static void main(String[] args) {
        int[] arr1={1,3,5,7};
        int[] arr2={0,2,6,8,9};
        int n=arr1.length;
        int m=arr2.length;

        int left=n-1;
        int right=0;
        while(left>=0 && right<m){
            if(arr1[left]>arr2[right]){
                int tmp=arr1[left];
                arr1[left]=arr2[right];
                arr2[right]=tmp;
                left--;
                right++;
            }else{
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int x:arr1){
            System.out.print(x+" ");
        }
        System.out.println();
        for(int x:arr2){
            System.out.print(x+" ");
        }

        /*
        0 1 2 3
        5 6 7 8 9

        */
    }
}
