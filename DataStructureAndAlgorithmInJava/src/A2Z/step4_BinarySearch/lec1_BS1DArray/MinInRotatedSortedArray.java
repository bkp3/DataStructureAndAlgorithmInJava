package A2Z.step4_BinarySearch.lec1_BS1DArray;

/*

Given an integer array arr of size N, sorted in ascending order (with distinct values). Now the array is rotated between 1 to N times which is unknown. Find the minimum element in the array.

Pre-requisites: Search in Rotated Sorted Array I,  Search in Rotated Sorted Array II & Binary Search algorithm

Examples

Example 1:
Input Format: arr = [4,5,6,7,0,1,2,3]
Result: 0
Explanation: Here, the element 0 is the minimum element in the array.

*/

public class MinInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr={4,5,6,7,1,2,3};
        int n=arr.length;

        int low=0;
        int high=n-1;
        int ans=Integer.MAX_VALUE;

        while(low<=high){
            int mid=(low+high)/2;
            if(arr[low]<=arr[mid]){
                ans = Math.min(ans,arr[low]);
                low=mid+1;
            }else{
                ans=Math.min(ans,arr[mid]);
                high=mid-1;
            }
        }
        System.out.println(ans);
    }
}
