package A2Z.step3_Arrays.lec3_Hard;

/*
Given an array of intervals, merge all the overlapping intervals and return an array of non-overlapping intervals.

Examples

Example 1:
Example 1:

Input: intervals=[[1,3],[2,6],[8,10],[15,18]]

Output: [[1,6],[8,10],[15,18]]

Explanation: Since intervals [1,3] and [2,6] are overlapping we can merge them to form [1,6]
 intervals.


*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {

    static void funBrute(int[][] arr,int n){
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            int start=arr[i][0];
            int end=arr[i][1];
            if(!ans.isEmpty() && end<=ans.get(ans.size()-1).get(1)){
                continue;
            }
            for(int j=i+1;j<n;j++){
                if(arr[j][0]<=end){
                    end=Math.max(end,arr[j][1]);
                }else{
                    break;
                }
            }
            ans.add(Arrays.asList(start,end));
        }
        System.out.println(ans);
    }

    static void funOptimal(int[][] arr,int n){
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(ans.isEmpty() || arr[i][0]>ans.get(ans.size()-1).get(1)){
                ans.add(Arrays.asList(arr[i][0],arr[i][1]));
            }else{
                ans.get(ans.size()-1).set(1,Math.max(ans.get(ans.size()-1).get(1),arr[i][1]));
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int[][] arr={{1,3},{2,6},{8,9},{9,11},{8,10},{2,4},{15,18},{16,17}};
        int n=arr.length;

        //brute : O(n^2)
        funBrute(arr,n);
//        [[1, 6], [8, 11], [15, 18]]


        //OPtimal : O(n)
        funOptimal(arr,n);
//[[1, 6], [8, 11], [15, 18]]


    }
}
