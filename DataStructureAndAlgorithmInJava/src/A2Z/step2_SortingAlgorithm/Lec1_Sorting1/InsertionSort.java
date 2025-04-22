package A2Z.step2_SortingAlgorithm.Lec1_Sorting1;
/*
Takes an element and place it in its currect order


Approach:

Select an element in each iteration from the unsorted array(using a loop).
Place it in its corresponding position in the sorted part and shift the remaining elements accordingly (using an inner loop and swapping).
The “inner while loop” basically shifts the elements using swapping.

*/

public class InsertionSort {

    static void insertionSort(int[] arr,int n){
        for(int i=0;i<n;i++){
            int j=i;
            while(j>0 && arr[j-1]>arr[j]){
                int tmp=arr[j-1];
                arr[j-1]=arr[j];
                arr[j]=tmp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={13,46,24,52,20,9};
        int n=arr.length;
        for(int x:arr){
            System.out.print(x+" ");
        }
        System.out.println();
        insertionSort(arr,n);
        for(int x:arr){
            System.out.print(x+" ");
        }

        //13 46 24 52 20 9
        //9 13 20 24 46 52
    }
}
