package A2Z.step1_LearnTheBasics.lec2_BuildUpLogicalThinking;

/*
ABCDE
ABCD
ABC
AB
A


*/

public class Pattern15 {
    public static void main(String[] args) {
        int n=5;
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <=(n-i+1) ; j++) {
                System.out.print((char)('A'+(j-1)));
            }
            System.out.println();
        }
    }
}
