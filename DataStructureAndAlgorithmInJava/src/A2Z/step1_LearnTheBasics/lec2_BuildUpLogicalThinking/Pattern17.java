package A2Z.step1_LearnTheBasics.lec2_BuildUpLogicalThinking;



/*
   A
  ABA
 ABCBA
ABCDCBA


*/

public class Pattern17 {
    public static void main(String[] args) {
        int n=4;

        for (int i = 1; i <= n ; i++) {
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            int point=(2*i-1)/2;
            char c='A';
            for (int j = 1; j <=2*i-1 ; j++) {
                System.out.print(c);
                if(point>=j){
                    c++;
                }else{
                    c--;
                }

            }
            System.out.println();
        }
    }
}
