package A2Z.step4_BinarySearch.lec1_BS1DArray;

/*
Given a sorted array of N integers, write a program to find the index of the last occurrence of the target key. If the target is not found then return -1.

Note: Consider 0 based indexing

Examples:

Example 1:
Input: N = 7, target=13, array[] = {3,4,13,13,13,20,40}
Output: 4
Explanation: As the target value is 13 , it appears for the first time at index number 2.



*/

public class FirstAndLastOccurance {

    static int lowerBoundFun(int[] arr,int n,int x){
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
        return ans;
    }

    static int upperBoundfun(int[] arr,int n,int x){
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
        return ans;
    }


    public static void main(String[] args) {
        int[] arr={2,4,6,8,8,8,11,13};
        int n=arr.length;
        int x=8;
        int lb=lowerBoundFun(arr,n,x);
        int ub=upperBoundfun(arr,n,x);
        if(lb==n || arr[lb]!=x){
            System.out.println("-1, -1");
            return;
        }
        System.out.println(lb+", "+(ub-1));

        //3, 5

    }
}
