package A2Z.step3_Arrays.lec1_Easy;

public class RemoveDuplicatesInSortedArray {
    public static void main(String[] args) {
        int[] arr={1,1,2,2,2,3,3,3,3,3};
        int n=arr.length;

        int i=0;
        int j=i+1;
        while (j<n){
            if(arr[i]!=arr[j]){
                arr[i+1]=arr[j];
                i++;
            }
            j++;
        }
        for (int x:arr){
            System.out.print(x+" ");
        }
        //1 2 3 2 2 3 3 3 3 3
    }
}
