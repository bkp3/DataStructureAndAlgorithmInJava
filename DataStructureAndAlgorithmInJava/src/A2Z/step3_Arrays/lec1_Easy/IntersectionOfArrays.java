package A2Z.step3_Arrays.lec1_Easy;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfArrays {
    public static void main(String[] args) {
        int[] a1={1,2,2,3,3,4,5,6};
        int[] a2={2,3,3,5,6,6,7};

        List<Integer>list=new ArrayList<>();
        int i=0;
        int j=0;
        int n1=a1.length;
        int n2=a2.length;
        while(i<n1&&j<n2){
            if(a1[i]<a2[j]){
                i++;
            }else if(a1[i]>a2[j]){
                j++;
            }else{
                list.add(a1[i]);
                i++;
                j++;
            }
        }
        System.out.println(list);
        //[2, 3, 3, 5, 6]
    }
}
