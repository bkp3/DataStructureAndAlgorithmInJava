package A2Z.step1_LearnTheBasics.lec2_BuildUpLogicalThinking;

/*

1      1
12    21
123  321
12344321


*/

public class Pattern12 {
    public static void main(String[] args) {
        int n=4;
        for (int i = 1; i<=n; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(j);
            }
            for (int j = 1; j <=2*(n-i) ; j++) {
                System.out.print(" ");
            }
            for (int j = i; j >=1; j--) {
                System.out.print(j);
            }
            System.out.println(" ");
        }
    }
}
