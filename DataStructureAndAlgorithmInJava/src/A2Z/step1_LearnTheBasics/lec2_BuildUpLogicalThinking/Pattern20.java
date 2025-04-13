package A2Z.step1_LearnTheBasics.lec2_BuildUpLogicalThinking;

/*


 *        *
 **      **
 ***    ***
 ****  ****
 **********
 ****  ****
 ***    ***
 **      **
 *        *


*/

public class Pattern20 {
    public static void main(String[] args) {
        int n=5;
        for (int i = 1; i <= 2*n-1; i++) {

            for (int j = 1; j <= (i>n?2*n-i:i); j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= 2*(i>n?i-n:n-i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (i>n?2*n-i:i); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
