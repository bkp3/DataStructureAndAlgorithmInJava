package A2Z.step1_LearnTheBasics.lec2_BuildUpLogicalThinking;

/*

A
AB
ABC
ABCD
ABCDE


*/

public class Pattern14 {
    public static void main(String[] args) {
        int n=5;
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print((char)('A'+(j-1)));
            }
            System.out.println();
        }
    }
}
