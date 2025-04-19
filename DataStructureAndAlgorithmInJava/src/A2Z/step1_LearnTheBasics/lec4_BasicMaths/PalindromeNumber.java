package A2Z.step1_LearnTheBasics.lec4_BasicMaths;

/*

Given an integer N, return true if it is a palindrome else return false.

A palindrome is a number that reads the same backward as forward. For example, 121, 1331, and 4554 are palindromes because they remain the same when their digits are reversed.


*/

public class PalindromeNumber {

    static boolean fun(int n){
        int num=n;
        int rev=0;
        while(n>0){
            int rem=n%10;
            n=n/10;
            rev=rev*10+rem;
        }
        return num==rev;
    }

    public static void main(String[] args) {
        int n=1331;
        System.out.println(fun(n));
        //true
    }
}
