package A2Z.step2_SortingAlgorithm.Lec1_Sorting1;

/*
select minimum and swap


The algorithm steps are as follows:

First, we will select the range of the unsorted array using a loop (say i) that indicates the starting index of the range.
The loop will run forward from 0 to n-1. The value i = 0 means the range is from 0 to n-1, and similarly, i = 1 means the range is from 1 to n-1, and so on.
(Initially, the range will be the whole array starting from the first index.)
Now, in each iteration, we will select the minimum element from the range of the unsorted array using an inner loop.
After that, we will swap the minimum element with the first element of the selected range(in step 1).
Finally, after each iteration, we will find that the array is sorted up to the first index of the range.

*/

public class SelectionSort {
    static void selectionSort(int[] arr,int n){
        for(int i=0;i<n-1;i++){
            int min=i;
            for(int j=i;j<n;j++){
                if(arr[min]>arr[j]){
                    min=j;
                }
            }
            int tmp=arr[min];
            arr[min]=arr[i];
            arr[i]=tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr={13,46,24,52,20,9};
        int n=arr.length;
        for(int x:arr){
            System.out.print(x+" ");
        }
        System.out.println();
        selectionSort(arr,n);
        for(int x:arr){
            System.out.print(x+" ");
        }

        //13 46 24 52 20 9
        //9 13 20 24 46 52
    }
}
