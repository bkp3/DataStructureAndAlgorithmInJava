package A2Z.step1_LearnTheBasics.lec5_BasicRecursion;

public class PrintNumberNTimes {
    static int count=0;

    static void fun(int n){
        if(count==n){
            return;
        }
        count++;
        System.out.print(count+" ");
        fun(n);
    }

    public static void main(String[] args) {
        int n=5;
        fun(n);
        //1 2 3 4 5
    }
}
