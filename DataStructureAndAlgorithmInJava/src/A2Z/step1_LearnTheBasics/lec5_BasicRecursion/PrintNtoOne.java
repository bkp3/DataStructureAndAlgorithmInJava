package A2Z.step1_LearnTheBasics.lec5_BasicRecursion;

public class PrintNtoOne {

    static void fun(int i,int n){
        if(i<1){
            return;
        }
        System.out.print(i+" ");
        fun(i-1,n);
    }

    static void funBackTrack(int i,int n){
        if(i>n){
            return;
        }
        funBackTrack(i+1,n);
        System.out.print(i+" ");
    }
    public static void main(String[] args) {
        int n=4;
        fun(n,n);
        //4 3 2 1

        //using backtrack
        funBackTrack(1,n);
        //4 3 2 1
    }
}
