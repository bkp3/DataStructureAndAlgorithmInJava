package A2Z.step3_Arrays.lec1_Easy;

/*
Given an array of integers, rotating array of elements by k elements either left or right.

Examples:

Example 1:
Input: N = 7, array[] = {1,2,3,4,5,6,7} , k=2 , right
Output: 6 7 1 2 3 4 5
Explanation: array is rotated to right by 2 position .


*/

public class LeftArrayByDPlace {
    static void rev(int[] arr,int l, int r){
        for(int i=l;i<((r-l)/2)+l;i++){
            int tmp=arr[i];
            arr[i]=arr[r-i-1+l];
            arr[r-i-1+l]=tmp;
        }
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        int d=3;
        int n=arr.length;
        rev(arr,0,d);
        rev(arr,d,n);
        rev(arr,0,n);

        for(int x:arr){
            System.out.print(x+" ");
        }
        //4 5 6 7 1 2 3
        System.out.println();
    }
}
