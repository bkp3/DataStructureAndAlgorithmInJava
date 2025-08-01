package A2Z.step4_BinarySearch.lec1_BS1DArray;

public class BinarySearchCode {

    private static int funIterative(int[] arr,int n,int target){
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }

    private static int funBS(int[] arr,int low,int high,int target){
        if(low>high){
            return -1;
        }
        int mid=(low+high)/2;
        if(arr[mid]==target){
            return mid;
        }else if(arr[mid]<target){
            return funBS(arr,mid+1,high,target);
        }
        return funBS(arr,low,mid-1,target);
    }


    public static void main(String[] args) {
        int[] arr={3,4,6,7,9,12,16,17};
        int n= arr.length;
        int target=6;

        //Iterative: O(logn)
        int ans=funIterative(arr,n,target);
        System.out.println(ans);
        //2


        //recursive
        int target1=13;
        int ans1=funBS(arr,0,n-1,target1);
        System.out.println(ans1);
        //-1
    }
}
