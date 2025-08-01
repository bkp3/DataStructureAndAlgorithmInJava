package A2Z.step4_BinarySearch.lec1_BS1DArray;
/*
Given a sorted array of N integers and an integer x, write a program to find the lower bound of x.

Pre-requisite: Binary Search algorithm

Examples

Example 1:
Input Format: N = 4, arr[] = {1,2,2,3}, x = 2
Result: 1
Explanation: Index 1 is the smallest index such that arr[1] >= x.

Example 2:
Input Format: N = 5, arr[] = {3,5,8,15,19}, x = 9
Result: 3
Explanation: Index 3 is the smallest index such that arr[3] >= x.



*/

public class ImplementLowerBound {
    public static void main(String[] args) {
        int[] arr={1,2,2,3};
        int n=arr.length;
        int x=2;

        int low=0;
        int high=n-1;
        int ans=n;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=x){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        System.out.println(ans);
        //1
    }
}
