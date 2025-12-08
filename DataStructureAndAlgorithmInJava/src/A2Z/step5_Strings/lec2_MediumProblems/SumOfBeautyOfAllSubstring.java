package A2Z.step5_Strings.lec2_MediumProblems;

import java.util.HashMap;

public class SumOfBeautyOfAllSubstring {
    static void main() {
        String str="xyx";
        int n=str.length();
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                String s=str.substring(i,j+1);
                HashMap<Character,Integer>mp=new HashMap<>();
                for(char x:s.toCharArray()){
                    mp.put(x,mp.getOrDefault(x,0)+1);
                }
                int maxi=Integer.MIN_VALUE;
                int mini=Integer.MAX_VALUE;
                for(var e:mp.entrySet()){
                    maxi=Math.max(maxi,e.getValue());
                    mini=Math.min(mini,e.getValue());
                }
                if(maxi==Integer.MIN_VALUE || mini==Integer.MAX_VALUE) continue;

                res = res + (maxi-mini);
            }
        }
        System.out.println(res);
    }
}
