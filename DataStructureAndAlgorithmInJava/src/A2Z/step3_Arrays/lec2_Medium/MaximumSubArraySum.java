package A2Z.step3_Arrays.lec2_Medium;

/*
Given an integer array arr, find the contiguous subarray (containing at least one number) which
has the largest sum and returns its sum and prints the subarray.

Examples
Example 1:

Input: arr = [-2,1,-3,4,-1,2,1,-5,4]

Output: 6

Explanation: [4,-1,2,1] has the largest sum = 6.




*/

public class MaximumSubArraySum {

    //find maximum subarray sum
    static int kadaneAlgo(int[] arr,int n){
        int maxi=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+arr[i];
            if(sum>maxi){
                maxi=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return maxi;
    }

    //print subarray
    static void kadaneAlgoPrintSubArray(int[] arr,int n){
        int start=-1;
        int x=-1;
        int y=-1;
        int maxi=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            if(sum==0){
                start=i;
            }
            sum=sum+arr[i];
            if(sum>maxi){
                maxi=sum;
                x=start;
                y=i;
            }
            if(sum<0){
                sum=0;
            }
        }
        for(int i=x;i<=y;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr={-2,1,-3,4,-1,2,1,-5,4};
        int n=arr.length;

        // brute : 3 for loops
        // better : 2 for loops
        //optimal : kadane's algorithm

        int ans=kadaneAlgo(arr,n);
        System.out.println(ans);
        //6

        //print subarray
        kadaneAlgoPrintSubArray(arr,n);
        //4 -1 2 1

    }
}
