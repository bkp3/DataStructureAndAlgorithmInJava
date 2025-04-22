package A2Z.step2_SortingAlgorithm.Lec1_Sorting1;

/*
push the max to the last by adjacant swaps


The algorithm steps are as follows:

First, we will select the range of the unsorted array. For that, we will run a loop(say i) that will signify the last index of the selected range. The loop will run backward from index n-1 to 0(where n = size of the array). The value i = n-1 means the range is from 0 to n-1, and similarly, i = n-2 means the range is from 0 to n-2, and so on.
Within the loop, we will run another loop(say j, runs from 0 to i-1 though the range is from 0 to i) to push the maximum element to the last index of the selected range, by repeatedly swapping adjacent elements.
Basically, we will swap adjacent elements(if arr[j] > arr[j+1]) until the maximum element of the range reaches the end.
Thus, after each iteration, the last part of the array will become sorted. Like: after the first iteration, the array up to the last index will be sorted, and after the second iteration, the array up to the second last index will be sorted, and so on.
After (n-1) iteration, the whole array will be sorted.


*/

public class BubbleSort {

    static void bubbleSort(int[] arr,int n){
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
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
        bubbleSort(arr,n);
        for(int x:arr){
            System.out.print(x+" ");
        }

        //13 46 24 52 20 9
        //9 13 20 24 46 52
    }

}
