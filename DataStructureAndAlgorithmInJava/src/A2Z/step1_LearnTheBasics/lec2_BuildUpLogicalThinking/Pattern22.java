package A2Z.step1_LearnTheBasics.lec2_BuildUpLogicalThinking;

/*

4 4 4 4 4 4 4
4 3 3 3 3 3 4
4 3 2 2 2 3 4
4 3 2 1 2 3 4
4 3 2 2 2 3 4
4 3 3 3 3 3 4
4 4 4 4 4 4 4



*/

public class Pattern22 {
    public static void main(String[] args) {
        int n=4;

        for (int i = 1; i <= 2*n-1; i++) {

            for(int j=1;j<=2*n-1;j++){
                int top = i-1;
                int bottom = j-1;
                int right = (2*n - 2) - j+1;
                int left = (2*n - 2) - i+1;

                System.out.print(n- Math.min(Math.min(top,bottom), Math.min(left,right)) + " ");


            }
            System.out.println();
        }
    }
}
