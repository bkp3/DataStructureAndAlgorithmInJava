package A2Z.step5_Strings.lec1_BasicAndEasy;

/*
Input: s = "paper", t = "title"
Output: true

Input: s = "foo", t = "bar"
Output: false

*/

public class IsomorphicString {

    static boolean isIsomorphic(String s,String t){
        int[] m1=new int[256];
        int[] m2=new int[256];
        for(int i=0;i<s.length();i++){
            if(m1[s.charAt(i)]!=m2[t.charAt(i)]){
                return false;
            }
            m1[s.charAt(i)]++;
            m2[t.charAt(i)]++;
        }
        return true;
    }

    static void main() {
        String s = "paper";
        String t = "title";

        boolean flag=isIsomorphic(s,t);
        System.out.println(flag);



    }
}
