package A2Z.step1_LearnTheBasics.lec6_BasicHashing;

import java.util.HashMap;

public class CountFrequency {
    public static void main(String[] args) {
        int[] arr={10,5,10,15,10,5};
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int x:arr){
            if(mp.containsKey(x)){
                mp.put(x,mp.get(x)+1);
            }else{
                mp.put(x,1);
            }
        }
        for(var e:mp.entrySet()){
            System.out.println(e.getKey()+" -> "+e.getValue());
        }
        /*
5 -> 2
10 -> 3
15 -> 1
        */
    }
}
