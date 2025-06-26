package A2Z.step3_Arrays.lec3_Hard;
/*
Given an array of integers A and an integer B. Find the total number of subarrays having bitwise XOR of all elements equal to k.

Pre-requisite: Find the number of subarrays with the sum K

Examples

Example 1:
Input Format: A = [4, 2, 2, 6, 4] , k = 6
Result: 4
Explanation: The subarrays having XOR of their elements as 6 are  [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], [6]


*/

import java.util.HashMap;

public class CountOfSubarraysWithXorK {

    static void funBrute(int[] arr,int n,int k){
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int xr=0;
                for(int l=i;l<=j;l++){
                    xr=xr^arr[l];
                }
                if(xr==k){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    static void funBetter(int[] arr,int n,int k){
        int cnt=0;
        for(int i=0;i<n;i++){
            int xr=0;
            for(int j=i;j<n;j++){
                xr=xr^arr[j];
                if(xr==k){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    static void funOptimal(int[] arr,int n,int k){
        HashMap<Integer,Integer>mp=new HashMap<>();
        int cnt=0;
        int xr=0;
        mp.put(xr,1);
        for(int i=0;i<n;i++){
            xr=xr^arr[i];
            int x=xr^k;
            if(mp.get(x)!=null)
                cnt=cnt+mp.get(x);
            if(mp.get(xr)==null){
                mp.put(xr,1);
            }else{
                mp.put(xr, mp.get(xr)+1);
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        int[] arr={4, 2, 2, 6, 4};
        int n=arr.length;
        int k=6;

        //Brute : 3loops
        funBrute(arr,n,k);
        //4

        //Better : 2 loops
        funBetter(arr,n,k);
        //4

        //Optimal : prefix sum
        funOptimal(arr,n,k);
        //4
    }

}
