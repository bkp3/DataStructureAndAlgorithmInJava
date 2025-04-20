package A2Z.step1_LearnTheBasics.lec5_BasicRecursion;

public class PrintNameNTimes {

    static void fun(int i,int n){
        if(i>n){
            return;
        }
        System.out.print("Java ");
        fun(i+1,n);
    }

    public static void main(String[] args) {
        int n=4;
        fun(1,n);
        //Java Java Java Java
    }
}
