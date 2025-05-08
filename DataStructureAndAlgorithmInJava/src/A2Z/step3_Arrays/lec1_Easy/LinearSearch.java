package A2Z.step3_Arrays.lec1_Easy;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr={6,7,8,4,1};
        int n=arr.length;
        int num=4;
        int idx=-1;
        for(int i=0;i<n;i++){
            if(arr[i]==num){
                idx=i;
                break;
            }
        }
        System.out.println(idx);
        //3
    }
}
