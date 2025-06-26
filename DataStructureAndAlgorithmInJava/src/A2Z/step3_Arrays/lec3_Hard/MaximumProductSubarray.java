package A2Z.step3_Arrays.lec3_Hard;

/*
Given an array that contains both negative and positive integers, find the maximum product subarray.

Examples

Example 1:
Input:
 Nums = [1,2,3,4,5,0]
Output:
 120
Explanation:
 In the given array, we can see 1×2×3×4×5 gives maximum product value.



*/

public class MaximumProductSubarray {

    static void funBrute(int[] arr,int n){
        int maxi=-1;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int prod=1;
                for(int k=i;k<=j;k++){
                   prod=prod*arr[k];
                }
                maxi=Math.max(maxi,prod);
            }
        }
        System.out.println(maxi);
    }

    static void funBetter(int[] arr,int n){
        int maxi=-1;
        for(int i=0;i<n;i++){
            int prod=1;
            for(int j=i;j<n;j++){
                prod=prod*arr[j];
                maxi=Math.max(maxi,prod);
            }
        }
        System.out.println(maxi);
    }

    static void funOptimal(int[] arr,int n){
        int maxi=-1;
        int pre=1;
        int suff=1;
        for(int i=0;i<n;i++){
            if(pre==0){
                pre=1;
            }
            if(suff==0){
                suff=1;
            }
            pre=pre*arr[i];
            suff=suff*arr[i];
            maxi=Math.max(maxi,Math.max(pre,suff));
        }
        System.out.println(maxi);

    }

    public static void main(String[] args) {
        int[] arr={2,3,-2,4};
        int n=arr.length;

        //Brute : 3 for loops
        funBrute(arr,n);
        //6

        //Better : 2 for loops
        funBetter(arr,n);
        //6

        //Optimal : 1 for loops
        funOptimal(arr,n);
        //6

    }
}
