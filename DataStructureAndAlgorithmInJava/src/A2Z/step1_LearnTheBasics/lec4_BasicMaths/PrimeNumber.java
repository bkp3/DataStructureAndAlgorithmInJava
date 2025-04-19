package A2Z.step1_LearnTheBasics.lec4_BasicMaths;

/*
Given an integer N, check whether it is prime or not. A prime number is a number that is only divisible by 1 and itself and the total number of divisors is 2.
Example 1:
                Input:N = 2

                Output:True

                Explanation: 2 is a prime number because it has two divisors: 1 and 2 (the number itself).


*/

public class PrimeNumber {

    static boolean fun(int n){
        int cnt=0;
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                cnt++;
                if((n/i)!=i){
                    cnt++;
                }
            }
        }
        return cnt==2;
    }

    public static void main(String[] args) {
        int n=15;
        System.out.println(fun(n));
        //false
    }
}
