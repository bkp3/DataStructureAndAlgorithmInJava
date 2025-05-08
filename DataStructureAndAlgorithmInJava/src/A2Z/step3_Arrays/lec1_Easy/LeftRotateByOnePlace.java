package A2Z.step3_Arrays.lec1_Easy;

public class LeftRotateByOnePlace {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int n=arr.length;
        int tmp=arr[0];
        for(int i=1;i<n;i++){
            arr[i-1]=arr[i];
        }
        arr[n-1]=tmp;
        for(int x:arr){
            System.out.print(x+" ");
        }
        System.out.println();
        //2 3 4 5 1
    }
}
