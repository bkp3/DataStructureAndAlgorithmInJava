package A2Z.step5_Strings.lec2_MediumProblems;

public class LongestPalindromicSubstring {
    static void main() {
        String str="abhfdfhf";
        int n= str.length();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                String s=str.substring(i,j+1);
                String rev=(new StringBuilder(s)).reverse().toString();
                if(s.equals(rev)){
                    max=Math.max(max,s.length());
                }
            }
        }
        System.out.println(max);
    }
}
