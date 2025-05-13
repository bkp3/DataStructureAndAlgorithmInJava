package A2Z.step3_Arrays.lec2_Medium;

public class Sort012 {

    public static void main(String[] args) {
        int[] arr={2,0,2,1,1,0};
        int n=arr.length;
        int low=0;
        int mid=0;
        int high=n-1;
        while(mid<=high){
            if(arr[mid]==0){
                int tmp=arr[low];
                arr[low]=arr[mid];
                arr[mid]=tmp;
                low++;
                mid++;
            } else if (arr[mid]==1) {
                mid++;
            } else if (arr[mid]==2) {
                int tmp=arr[mid];
                arr[mid]=arr[high];
                arr[high]=tmp;
                high--;
            }
        }
        for(int x:arr){
            System.out.print(x+ " ");
        }
        //0 0 1 1 2 2
    }
}
