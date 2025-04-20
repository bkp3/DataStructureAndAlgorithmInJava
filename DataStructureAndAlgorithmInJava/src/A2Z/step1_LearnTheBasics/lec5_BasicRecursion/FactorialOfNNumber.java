package A2Z.step1_LearnTheBasics.lec5_BasicRecursion;

public class FactorialOfNNumber {

    static int fun(int n){
        if(n==1){
            return 1;
        }
        return n*fun(n-1);
    }

    public static void main(String[] args) {
        int n=3;
        System.out.println(fun(n));
        //6
    }
}
