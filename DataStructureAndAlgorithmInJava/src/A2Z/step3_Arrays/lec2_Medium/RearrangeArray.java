package A2Z.step3_Arrays.lec2_Medium;
/*
There’s an array ‘A’ of size ‘N’ with an equal number of positive and negative elements. Without altering the relative order of positive and negative elements, you must return an array of alternately positive and negative values.

Note: Start the array with positive elements.

Examples:

Example 1:

Input:
arr[] = {1,2,-4,-5}, N = 4
Output:
1 -4 2 -5

Explanation:

Positive elements = 1,2
Negative elements = -4,-5
To maintain relative ordering, 1 must occur before 2, and -4 must occur before -5.


*/

public class RearrangeArray {
    public static void main(String[] args) {
        int[] arr = {1,2,-4,-5};
        int n=arr.length;
        int[] ans=new int[n];
        int posIdx=0;
        int negIdx=1;
        for(int i=0;i<n;i++){
            if(arr[i]<0){
                ans[negIdx]=arr[i];
                negIdx=negIdx+2;
            }else{
                ans[posIdx]=arr[i];
                posIdx=posIdx+2;
            }
        }
        for (int x:ans){
            System.out.print(x+" ");
        }
        //1 -4 2 -5
    }
}
