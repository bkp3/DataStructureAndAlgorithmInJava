package A2Z.step1_LearnTheBasics.lec4_BasicMaths;

/*
 Given two integers N1 and N2, find their greatest common divisor.

The Greatest Common Divisor of any two integers is the largest number that divides both integers.

 Example 1:
 Input:N1 = 9, N2 = 12


 Output:3
 Explanation:Factors of 9: 1, 3 and 9
 Factors of 12: 1, 2, 3, 4, 6, 12
 Common Factors: 1, 3 out of which 3 is the greatest hence it is the GCD.


*/

public class GCD {
    static void fun(int n1,int n2){
        for(int i=Math.min(n1,n2);i>=1;i--){
            if(n1%i==0&&n2%i==0){
                System.out.println(i);
                break;
            }
        }
    }
    static void fun1(int n1,int n2){
        while(n1>0 && n2>0){
            if(n1>n2){
                n1=n1%n2;
            }else{
                n2=n2%n1;
            }
        }
        System.out.println(n1==0?n2:n1);
    }
    public static void main(String[] args) {
        int n1=20;
        int n2=15;
        fun(n1,n2);
        //5

        fun1(n1,n2);
        //5
    }
}
