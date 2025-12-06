package A2Z.step5_Strings.lec1_BasicAndEasy;
/*
Example 1:
Input: CAT, ACT
Output: true
Explanation: Since the count of every letter of both strings are equal.

Example 2:
Input: RULES, LESRT
Output: false
Explanation: Since the count of U and T  is not equal in both strings.


*/

import java.util.Arrays;

public class TwoStringAnagram {
    static void main() {
        String s1="CAT";
        String s2="ACT";

        //brute force
        char[] arr1=s1.toCharArray();
        char[] arr2=s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        boolean ans1=true;
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]!=arr2[i]){
                ans1=false;
                break;
            }
        }
        System.out.println(ans1);

        //optimal
        int[] arr=new int[26];
        boolean ans2=true;
        for(char x:s1.toCharArray()){
            arr[x-'A']++;
        }
        for(char x:s2.toCharArray()){
            arr[x-'A']--;
        }
        for(int i=0;i<26;i++){
            if(arr[i]!=0){
                ans2=false;
                break;
            }
        }
        System.out.println(ans2);

    }

}
