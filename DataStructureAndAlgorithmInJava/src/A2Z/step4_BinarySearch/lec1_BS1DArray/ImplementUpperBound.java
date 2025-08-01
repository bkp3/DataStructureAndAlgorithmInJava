package A2Z.step4_BinarySearch.lec1_BS1DArray;

/*
Given a sorted array of N integers and an integer x, write a program to find the upper bound of x.

Pre-requisite: Binary Search algorithm

Examples

Example 1:
Input Format: N = 4, arr[] = {1,2,2,3}, x = 2
Result: 3
Explanation: Index 3 is the smallest index such that arr[3] > x.

Example 2:
Input Format: N = 6, arr[] = {3,5,8,9,15,19}, x = 9
Result: 4
Explanation: Index 4 is the smallest index such that arr[4] > x.


*/

public class ImplementUpperBound {
    public static void main(String[] args) {
        int[] arr={2,3,6,7,8,8,11,11,11,12};
        int n=arr.length;
        int x=6;

        int low=0;
        int high=n-1;
        int ans=n;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>x){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        System.out.println(ans);
        //3
    }
}
