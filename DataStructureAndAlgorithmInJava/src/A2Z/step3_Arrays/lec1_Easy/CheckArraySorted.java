package A2Z.step3_Arrays.lec1_Easy;

public class CheckArraySorted {
    public static void main(String[] args) {
        int[] arr={1,3,5,5,6,7,9};
        int n=arr.length;
        boolean flag=true;
        for(int i=1;i<n;i++){
            if(arr[i-1]>arr[i]){
                flag=false;
            }
        }
        System.out.println(flag);
        //true
    }
}
