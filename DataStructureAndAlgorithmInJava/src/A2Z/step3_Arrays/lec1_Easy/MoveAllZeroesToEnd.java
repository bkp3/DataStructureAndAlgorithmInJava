package A2Z.step3_Arrays.lec1_Easy;

/*

You are given an array of integers, your task is to move all the zeros in the array to the end of the array and move non-negative integers to the front by maintaining their order.

Examples

Example 1:
Input: 1 ,0 ,2 ,3 ,0 ,4 ,0 ,1
Output: 1 ,2 ,3 ,4 ,1 ,0 ,0 ,0
Explanation: All the zeros are moved to the end and non-negative integers are moved to front by maintaining order


*/

public class MoveAllZeroesToEnd {
    public static void main(String[] args) {
        int[] arr={1,0,2,3,2,0,0,4,5,1};
        int n=arr.length;

        int j=-1;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                j=i;
                break;
            }
        }
        for(int i=j+1;i<n;i++){
            if(arr[i]!=0){
                int tmp=arr[i];
                arr[i]=arr[j];
                arr[j]=tmp;
                j++;
            }
        }
        for(int x:arr){
            System.out.print(x+" ");
        }
        //1 2 3 2 4 5 1 0 0 0
    }
}
