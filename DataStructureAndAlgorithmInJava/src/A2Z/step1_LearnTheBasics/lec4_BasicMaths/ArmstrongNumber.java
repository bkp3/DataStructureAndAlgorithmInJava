package A2Z.step1_LearnTheBasics.lec4_BasicMaths;

/*

Given an integer N, return true it is an Armstrong number otherwise return false.

An Amrstrong number is a number that is equal to the sum of its own digits each raised to the power of the number of digits.

 Example 1:
Input:N = 153

Output:True

Explanation: 13+53+33 = 1 + 125 + 27 = 153

*/

public class ArmstrongNumber {

    static boolean fun(int n){
        int num=n;
        int count=(int)Math.log10(n)+1;
        int sum=0;
        while(n>0){
            int rem=n%10;
            n=n/10;
            sum=sum+(int)Math.pow(rem,count);
        }
        return sum==num;
    }

    public static void main(String[] args) {
        int n=153;
        System.out.println(fun(n));
        //true
    }
}
