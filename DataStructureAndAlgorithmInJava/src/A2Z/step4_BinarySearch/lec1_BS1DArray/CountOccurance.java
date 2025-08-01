package A2Z.step4_BinarySearch.lec1_BS1DArray;

/*
You are given a sorted array containing N integers and a number X, you have to find the occurrences of X in the given array.

Examples

Example 1:
Input: N = 7,  X = 3 , array[] = {2, 2 , 3 , 3 , 3 , 3 , 4}
Output: 4
Explanation: 3 is occurring 4 times in
the given array so it is our answer.

*/

public class CountOccurance {
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
            System.out.println("0");
            return;
        }
        System.out.println(ub-lb);

        //3

    }
}
