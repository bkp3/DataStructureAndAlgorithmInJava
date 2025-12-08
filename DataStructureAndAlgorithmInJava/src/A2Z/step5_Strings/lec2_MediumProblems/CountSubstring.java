package A2Z.step5_Strings.lec2_MediumProblems;

import java.util.HashMap;

public class CountSubstring {
    static void main() {
        String s = "pqpqs";
        int k = 2;
        int count=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String str=s.substring(i,j);
                HashMap<Character,Integer>mp=new HashMap<>();
                for(char x:str.toCharArray()){
                    mp.put(x,mp.getOrDefault(x,0)+1);
                }
                if(mp.size()==k){
                    count++;
                }
            }

        }
        System.out.println(count);
    }
}
