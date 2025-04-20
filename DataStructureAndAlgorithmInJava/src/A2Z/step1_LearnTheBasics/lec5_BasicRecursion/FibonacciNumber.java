package A2Z.step1_LearnTheBasics.lec5_BasicRecursion;
/*
Given an integer N. Print the Fibonacci series up to the Nth term.

Examples:

Example 1:
Input: N = 5
Output: 0 1 1 2 3 5
Explanation: 0 1 1 2 3 5 is the fibonacci series up to 5th term.(0 based indexing)



*/

public class FibonacciNumber {
    
    static int fun(int n){
        if(n<=1){
            return n;
        }
        int last=fun(n-1);
        int slast=fun(n-2);
        return last+slast;
    }
    
    public static void main(String[] args) {
        int n=4;
        System.out.println(fun(n));
        //3
    }
}
