package A2Z.step5_Strings.lec2_MediumProblems;

public class SortCharactersByFreq {
    static void main() {
        String s = "raaaajj";
        int[] arr=new int[26];
        for(char x:s.toCharArray()){
            arr[x-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<26;i++){
            if(arr[i]==0) continue;

            for(int j=0;j<arr[i];j++){
                sb.append((char)(i+97));
            }
        }
        System.out.println(sb);



    }

}
