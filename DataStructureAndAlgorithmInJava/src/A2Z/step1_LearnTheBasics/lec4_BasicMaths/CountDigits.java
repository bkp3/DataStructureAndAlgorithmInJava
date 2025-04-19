package A2Z.step1_LearnTheBasics.lec4_BasicMaths;

public class CountDigits {
    static int count(int n){
        int count=0;
        while(n>0){
            int rem=n%10;
            n=n/10;
            count++;
        }
        return count;
    }
    static int count1(int n){
        int ans=(int)Math.log10(n)+1;
        return ans;
    }
    public static void main(String[] args) {
        int N=7780;

        System.out.println(count(N));
        // op : 4

        System.out.println(count1(N));
        // op : 4

    }
}
