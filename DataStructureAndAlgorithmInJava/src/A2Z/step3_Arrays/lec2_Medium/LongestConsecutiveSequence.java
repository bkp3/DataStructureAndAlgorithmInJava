package A2Z.step3_Arrays.lec2_Medium;

/*
You are given an array of ‘N’ integers. You need to find the length of the longest sequence which contains the consecutive elements.

Examples

Example 1:

Input: [100, 200, 1, 3, 2, 4]

Output: 4

Explanation: The longest consecutive subsequence is 1, 2, 3, and 4.


*/

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        //brute : for-while loop
        //better : sort-1for loop
        //optimal : using hashset

        int[] arr={100, 200, 1, 3, 2, 4};
        int n=arr.length;
        int longest=1;
        HashSet<Integer>st=new HashSet<>();
        for(int x:arr){
            st.add(x);
        }
        for(int it:st){
            if(!st.contains(it-1)){
                int cnt=1;
                int x=it;
                while (st.contains(x+1)){
                    x=x+1;
                    cnt=cnt+1;
                }
                longest=Math.max(longest,cnt);
            }
        }
        System.out.println(longest);
        //4
    }
}
