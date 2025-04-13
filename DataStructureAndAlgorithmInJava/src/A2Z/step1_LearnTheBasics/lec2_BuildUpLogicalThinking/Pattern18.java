package A2Z.step1_LearnTheBasics.lec2_BuildUpLogicalThinking;


/*

E
DE
CDE
BCDE
ABCDE

*/

public class Pattern18 {
    public static void main(String[] args) {
        int n=5;
        for (int i = 1; i <= n; i++) {
            char c='A';
            for(int j=i;j>=1;j--){
                System.out.print((char)(c+n-j));

            }

            System.out.println();
        }
    }
}
