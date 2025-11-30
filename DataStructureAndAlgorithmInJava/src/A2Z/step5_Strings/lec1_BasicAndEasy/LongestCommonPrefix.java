package A2Z.step5_Strings.lec1_BasicAndEasy;

import java.util.Arrays;

/*
str = ["flower", "flow", "flight"]
Output: "fl"


*/

public class LongestCommonPrefix {
    static void main() {
        String[] arr={"flower", "flow", "flight"};
        Arrays.sort(arr);
        String first=arr[0];
        String last=arr[arr.length-1];
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<Math.min(first.length(),last.length());i++){
            if(first.charAt(i)!=last.charAt(i)){
                break;
            }
            sb.append(first.charAt(i));
        }
        System.out.println(sb);
        //fl
    }
}
