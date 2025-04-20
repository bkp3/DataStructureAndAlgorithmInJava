package A2Z.step1_LearnTheBasics.lec5_BasicRecursion;

public class SumOfNNumber {

    static void funParameterized(int i,int sum){
        if(i<1){
            System.out.println(sum);
            return;
        }
        funParameterized(i-1,sum+i);
    }

    static int funFuncational(int n){
        if(n==0){
            return 0;
        }
        return n+funFuncational(n-1);
    }

    public static void main(String[] args) {
        int n=3;
        //parameterized
        funParameterized(n,0);
        //6


        System.out.println();

        //functional
        System.out.println(funFuncational(n));
        //6
    }
}
