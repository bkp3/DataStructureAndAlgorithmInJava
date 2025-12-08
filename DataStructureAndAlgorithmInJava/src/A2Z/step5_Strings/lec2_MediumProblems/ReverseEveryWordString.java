package A2Z.step5_Strings.lec2_MediumProblems;

import java.util.Arrays;

public class ReverseEveryWordString {
    static void main() {
        String str=" amazing    coding skills ";
        str=str.trim();
        String[] arr=str.split("\\s+");
        for(int i=0;i<arr.length/2;i++){
            String tmp=arr[i];
            arr[i]=arr[arr.length-i-1];
            arr[arr.length-i-1]=tmp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
