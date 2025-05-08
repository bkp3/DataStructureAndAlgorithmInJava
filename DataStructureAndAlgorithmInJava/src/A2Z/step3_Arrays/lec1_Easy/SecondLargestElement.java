package A2Z.step3_Arrays.lec1_Easy;

public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr={2,5,1,3,0};
        int n=arr.length;

        int first=arr[0];
        int second=-1;
        for(int i=0;i<n;i++){
            if(arr[i]>first){
                second=first;
                first=arr[i];
            } else if (arr[i]>second && arr[i]<first) {
                second=arr[i];
            }
        }
        System.out.println(second);
        //3
    }
}
