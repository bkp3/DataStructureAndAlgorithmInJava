package A2Z.step1_LearnTheBasics.lec6_BasicHashing;

import java.util.HashMap;

public class HighestLowestFrequency {
    public static void main(String[] args) {
        int[] arr={10,5,10,15,10,5};
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int x:arr){
            if(mp.containsKey(x)){
                mp.put(x,mp.get(x)+1);
            }else{
                mp.put(x,1);
            }
        }
        int h=Integer.MIN_VALUE;
        int eh=0;
        int l=Integer.MAX_VALUE;
        int el=0;
        for(var e:mp.entrySet()){
            if(e.getValue()>h){
                h=e.getValue();
                eh=e.getKey();
            }
            if(e.getValue()<l){
                l=e.getValue();
                el=e.getKey();
            }
        }
        System.out.println(eh+" -> "+el);
        //10 -> 15
    }
}
