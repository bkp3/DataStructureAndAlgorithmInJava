package A2Z.step3_Arrays.lec2_Medium;
/*
Given an array, print all the elements which are leaders. A Leader is an element that is greater than all of the elements on its right side in the array.

Examples

Example 1:
Input:
 arr = [4, 7, 1, 0]
Output:
 7 1 0
Explanation:
 Rightmost element is always a leader. 7 and 1 are greater than the elements in their right side.



*/

import java.util.ArrayList;
import java.util.List;

public class LeadersInArray {
    public static void main(String[] args) {
        //brute : 2 for loops O(n^2) O(n)
        //optimal : back iteration O(n),O(n)
        int[] arr={4,7,1,0};
        int n=arr.length;
        List<Integer>ans=new ArrayList<>();
        int maxi=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            if(arr[i]>maxi){
                ans.add(arr[i]);
            }
            maxi=Math.max(maxi,arr[i]);
        }
        System.out.println(ans);
        //[0, 1, 7]
    }
}
