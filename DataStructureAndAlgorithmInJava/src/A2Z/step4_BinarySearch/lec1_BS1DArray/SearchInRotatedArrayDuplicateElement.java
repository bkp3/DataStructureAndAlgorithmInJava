package A2Z.step4_BinarySearch.lec1_BS1DArray;

/*
Given an integer array arr of size N, sorted in ascending order (may contain duplicate values) and a target value k. Now the array is rotated at some pivot point unknown to you. Return True if k is present and otherwise, return False.

Pre-requisite: Search Element in Rotated Sorted Array I & Binary Search algorithm

Examples

Example 1:
Input Format: arr = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6], k = 3
Result: True
Explanation: The element 3 is present in the array. So, the answer is True.


*/

public class SearchInRotatedArrayDuplicateElement {
    private static boolean binarySearch(int[] arr,int n,int target){
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target){
                return true;
            }
            if(arr[low]==arr[mid]&&arr[mid]==arr[high]){
                low=low+1;
                high=high-1;
                continue;
            }
            //left sorted
            if(arr[low]<=arr[mid]){
                if(arr[low]<=target && target<=arr[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                //right sorted
                if(arr[mid]<=target && target<=arr[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
//        int[] arr={7,8,9,1,2,3,4,5,6};
        int[] arr={3,1,2,3,3,3,3};
        int target=1;
        int n=arr.length;
        boolean flag=binarySearch(arr,n,target);
        System.out.println(flag);
        //true

    }
}
