package A2Z.step5_Strings.lec1_BasicAndEasy;
/*
Input: s = "welcome to the jungle"
Output: "jungle the to welcome"
*/

public class ReverseWordsString {
    static void main() {
        String str="welcome to the jungle";
        String[] arr=str.split("\\s");
        for(int i=0;i<arr.length/2;i++){
            String temp=arr[i];
            arr[i]=arr[arr.length-i-1];
            arr[arr.length-i-1]=temp;
        }
        for(String x:arr){
            System.out.println(x);
        }
    }
}
