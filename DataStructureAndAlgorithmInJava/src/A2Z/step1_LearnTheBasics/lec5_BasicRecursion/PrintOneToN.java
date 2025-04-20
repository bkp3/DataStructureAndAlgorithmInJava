package A2Z.step1_LearnTheBasics.lec5_BasicRecursion;

public class PrintOneToN {

    static void fun(int i,int n){
        if(i>n){
            return;
        }
        System.out.print(i+" ");
        fun(i+1,n);
    }

    static void funBackTrack(int i,int n){
        if(i<1){
            return;
        }
        funBackTrack(i-1,n);
        System.out.print(i+" ");
    }

    public static void main(String[] args) {
        int n=4;
        fun(1,n);
        //1 2 3 4

        //using backtrack
        funBackTrack(n,n);
        //1 2 3 4
    }
}
