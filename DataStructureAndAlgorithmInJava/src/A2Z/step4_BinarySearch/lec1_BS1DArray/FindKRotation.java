package A2Z.step4_BinarySearch.lec1_BS1DArray;
/*
Given an integer array arr of size N, sorted in ascending order (with distinct values). Now the array is rotated between 1 to N times which is unknown. Find how many times the array has been rotated.

Pre-requisites: Find minimum in Rotated Sorted Array,  Search in Rotated Sorted Array II & Binary Search algorithm

Examples

Example 1:
Input Format: arr = [4,5,6,7,0,1,2,3]
Result: 4
Explanation: The original array should be [0,1,2,3,4,5,6,7]. So, we can notice that the array has been rotated 4 times.

Example 2:
Input Format: arr = [3,4,5,1,2]
Result: 3
Explanation: The original array should be [1,2,3,4,5]. So, we can notice that the array has been rotated 3 times.





*/

public class FindKRotation {

    public static void main(String[] args) {
        int[] arr={3,4,5,1,2};
        int n=arr.length;
        int low=0;
        int high=n-1;
        int idx=-1;
        int ans=Integer.MAX_VALUE;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[low]<=arr[mid]){
                if(arr[low]<ans){
                    idx=low;
                    ans=arr[low];
                }
                low=mid+1;
            }else{
                if(arr[mid]<ans){
                    idx=mid;
                    ans=arr[mid];
                }
                high=mid-1;
            }
        }
        System.out.println(idx);

    }
}
