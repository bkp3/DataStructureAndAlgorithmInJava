package A2Z.step3_Arrays.lec3_Hard;


/*
Given an array of N integers, your task is to find unique triplets that add up to give a sum of zero. In short, you need to return an array of all the unique triplets [arr[a], arr[b], arr[c]] such that i!=j, j!=k, k!=i, and their sum is equal to zero.

Pre-requisite: 2 Sum Problem

Examples

Example 1:

Input: nums = [-1,0,1,2,-1,-4]

Output: [[-1,-1,2],[-1,0,1]]

Explanation: Out of all possible unique triplets possible, [-1,-1,2] and [-1,0,1] satisfy the condition of summing up to zero with i!=j!=k



*/

import java.util.*;

public class ThreeSum {

    static void funBrute(int[] arr,int n){
        HashSet<List<Integer>>st=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    int sum=arr[i]+arr[j]+arr[k];
                    if(sum==0){
                        List<Integer>tmp= Arrays.asList(arr[i],arr[j],arr[k]);
                        Collections.sort(tmp);
                        st.add(tmp);
                    }
                }
            }
        }
        System.out.println(st);
    }

    static void funBetter(int[] arr,int n){
        HashSet<List<Integer>>st=new HashSet<>();
        for(int i=0;i<n;i++){
            HashSet<Integer>tmp=new HashSet<>();
            for(int j=i+1;j<n;j++){
                int sum=-(arr[i]+arr[j]);
                if(tmp.contains(sum)){
                    List<Integer>list=Arrays.asList(arr[i],arr[j],sum);
                    Collections.sort(list);
                    st.add(list);
                }
                tmp.add(arr[j]);
            }
        }
        System.out.println(st);
    }

    static void funOptimal(int[] arr,int n){
        List<List<Integer>>list=new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            if(i>0 && arr[i]==arr[i-1]){
                continue;
            }
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum=arr[i]+arr[j]+arr[k];
                if(sum<0){
                    j++;
                } else if (sum>0) {
                    k--;
                }else{
                    List<Integer>tmp=Arrays.asList(arr[i],arr[j],arr[k]);
                    list.add(tmp);
                    j++;
                    k--;
                    while(j<k && arr[j]==arr[j-1]){
                        j++;
                    }
                    while (j<k && arr[k]==arr[k+1]){
                        k--;
                    }
                }
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        int[] arr={-1,0,1,2,-1,-4};
        int n=arr.length;

        //Brute : 3 loops
        funBrute(arr,n);
//        [[-1, -1, 2], [-1, 0, 1]]


        //Better : 2loops + Hashing
        funBetter(arr,n);
//        [[-1, -1, 2], [-1, 0, 1]]

        //Optimal : sort + two pointer
        funOptimal(arr,n);
//        [[-1, -1, 2], [-1, 0, 1]]

    }

}
