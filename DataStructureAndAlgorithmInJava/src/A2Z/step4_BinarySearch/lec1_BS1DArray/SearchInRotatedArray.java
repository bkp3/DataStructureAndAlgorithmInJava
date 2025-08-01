package A2Z.step4_BinarySearch.lec1_BS1DArray;

/*
Given an integer array arr of size N, sorted in ascending order (with distinct values) and a target value k. Now the array is rotated at some pivot point unknown to you. Find the index at which k is present and if k is not present return -1.

Examples

Example 1:
Input Format: arr = [4,5,6,7,0,1,2,3], k = 0
Result: 4
Explanation: Here, the target is 0. We can see that 0 is present in the given rotated sorted array, nums. Thus, we get output as 4, which is the index at which 0 is present in the array.


*/

public class SearchInRotatedArray {

    private static int binarySearch(int[] arr,int n,int target){
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target){
                return mid;
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
        return -1;
    }

    public static void main(String[] args) {
        int[] arr={7,8,9,1,2,3,4,5,6};
        int target=1;
        int n=arr.length;
        int ans=binarySearch(arr,n,target);
        System.out.println(ans);
        //3

    }
}
