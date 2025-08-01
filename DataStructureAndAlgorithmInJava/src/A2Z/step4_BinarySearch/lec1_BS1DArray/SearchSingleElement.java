package A2Z.step4_BinarySearch.lec1_BS1DArray;
/*
Given an array of N integers. Every number in the array except one appears twice. Find the single number in the array.

Pre-requisite: Binary Search Algorithm

Examples

Example 1:
Input Format: arr[] = {1,1,2,2,3,3,4,5,5,6,6}
Result: 4
Explanation: Only the number 4 appears once in the array.

Example 2:

Input Format: arr[] = {1,1,3,5,5}
Result: 3
Explanation: Only the number 3 appears once in the array.


*/

public class SearchSingleElement {
    public static void main(String[] args) {
        int[] arr={1,1,2,2,3,3,4,5,5,6,6};
        int n=arr.length;

        if(n==1){
            System.out.println(arr[0]);
            return;
        }
        if(arr[0]!=arr[1]){
            System.out.println(arr[0]);
            return;
        }
        if(arr[n-1]!=arr[n-2]){
            System.out.println(arr[n-1]);
            return;
        }

        int low=1;
        int high=n-2;

        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]!=arr[mid+1] && arr[mid]!=arr[mid-1]){
                System.out.println(arr[mid]);
                return;
            }
            if((mid%2==1 && arr[mid-1]==arr[mid]) || (mid%2==0 && arr[mid]==arr[mid+1])){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
    }
}
