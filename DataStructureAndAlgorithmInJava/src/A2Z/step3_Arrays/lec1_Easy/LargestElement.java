package A2Z.step3_Arrays.lec1_Easy;

public class LargestElement {
    public static void main(String[] args) {
        int[] arr={2,5,1,3,0};
        int n=arr.length;

        int largest=Integer.MIN_VALUE;
        for(int x:arr){
            if(x>largest){
                largest=x;
            }
        }
        System.out.println(largest);
        //5
    }
}
