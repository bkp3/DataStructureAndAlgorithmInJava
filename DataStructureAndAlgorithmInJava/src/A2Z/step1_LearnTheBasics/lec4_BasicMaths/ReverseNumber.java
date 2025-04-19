package A2Z.step1_LearnTheBasics.lec4_BasicMaths;

/*

Given an integer N return the reverse of the given number.
Example 1:

Input:N = 12345
Output:54321

Explanation: The reverse of 12345 is 54321.


*/

public class ReverseNumber {

    static int fun(int n){
        int rev=0;
        while(n>0){
            int rem=n%10;
            n=n/10;
            rev=rev*10+rem;
        }
        return rev;
    }

    public static void main(String[] args) {
        int n=12345;
        System.out.println(fun(n));
        //op : 54321

    }

}
