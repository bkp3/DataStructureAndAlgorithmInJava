package A2Z.step5_Strings.lec2_MediumProblems;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralsInteger {
    static void main() {
        String s = "MCMXCIV";
        //1994
        Map<Character,Integer> mp=new HashMap<>();
        mp.put('I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('C',100);
        mp.put('D',500);
        mp.put('M',1000);
        int res=0;
        for(int i=0;i<s.length()-1;i++){
            if(mp.get(s.charAt(i))<mp.get(s.charAt(i+1))){
                res -= mp.get(s.charAt(i));
            }else{
                res += mp.get(s.charAt(i));
            }
        }
        System.out.println(res+mp.get(s.charAt(s.length()-1)));

    }
}
