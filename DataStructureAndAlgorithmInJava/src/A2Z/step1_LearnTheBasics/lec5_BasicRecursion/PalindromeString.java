package A2Z.step1_LearnTheBasics.lec5_BasicRecursion;
/*

"Given a string, check if the string is palindrome or not."
A string is said to be palindrome if the reverse of the string is the same as the string.

Examples:

Example 1:
Input: Str =  “ABCDCBA”
Output: Palindrome
Explanation: String when reversed is the same as string.



*/

public class PalindromeString {

    static boolean fun(int i,String s){
        if(i>=s.length()/2){
            return true;
        }
        if(s.charAt(i)!=s.charAt(s.length()-i-1)){
            return false;
        }
        return fun(i+1,s);
    }

    public static void main(String[] args) {
        String s="MADAM";
        System.out.println(fun(0,s));
        //true
    }
}
