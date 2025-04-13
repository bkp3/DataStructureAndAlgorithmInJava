package A2Z.step1_LearnTheBasics.lec2_BuildUpLogicalThinking;

/*


 **********
 ****  ****
 ***    ***
 **      **
 *        *
 *        *
 **      **
 ***    ***
 ****  ****
 **********

*/

public class Pattern19 {
    public static void main(String[] args) {
        int n=5;

        for (int i = 1; i <= 2*n ; i++) {

            for (int j = 1; j <=(i>n?i-n:n-i+1) ; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <=(i>n?2*(2*n-i):2*(i-1)) ; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <=(i>n?i-n:n-i+1) ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
