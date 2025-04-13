package A2Z.step1_LearnTheBasics.lec2_BuildUpLogicalThinking;

/*

1
01
101
0101
10101


*/

public class Pattern11 {
    public static void main(String[] args) {
        int n=5;
        int x=1;
        for (int i=1;i<=n;i++){
            x=i%2==0?0:1;
            for(int j=1;j<=i;j++){
                System.out.print(x);
                x=1-x;
            }
            System.out.println();
        }
    }
}
