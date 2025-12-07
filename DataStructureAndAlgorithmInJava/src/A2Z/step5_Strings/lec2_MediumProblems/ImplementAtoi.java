package A2Z.step5_Strings.lec2_MediumProblems;

public class ImplementAtoi {

    static int aToi(String str){
        int n=str.length();
        int i=0;
        int sign = 1;
        long res=0;
        while(i<n && str.charAt(i)==' ') i++;

        if(i==n) return 0;

        if(str.charAt(i)=='-'){
            sign=-1;
            i++;
        }else if(str.charAt(i)=='+'){
            i++;
        }
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            res = res * 10 + (str.charAt(i) - '0');
            if (sign * res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return (int)(sign * res);

    }

    static void main() {
        String str="1337c0d3";

        int ans=aToi(str);
        System.out.println(ans);



    }
}
