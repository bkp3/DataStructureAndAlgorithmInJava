package A2Z.step3_Arrays.lec3_Hard;

/*

Given an array of N integers, your task is to find unique quads that add up to give a target value. In short, you need to return an array of all the unique quadruplets [arr[a], arr[b], arr[c], arr[d]] such that their sum is equal to a given target.

Pre-req: 3-sum problem and 2-sum problem

Note:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
arr[a] + arr[b] + arr[c] + arr[d] == target

Examples

Example 1:
Input Format: arr[] = [1,0,-1,0,-2,2], target = 0
Result: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Explanation: We have to find unique quadruplets from the array such that the sum of those elements is equal to the target sum given that is 0. The result obtained is such that the sum of the quadruplets yields 0.

*/

import java.util.*;

public class FourSum {

    static void funBrute(int[] arr,int n,int target){
        HashSet<List<Integer>>ans=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    for(int l=k+1;l<n;l++){
                        int sum=arr[i]+arr[j]+arr[k]+arr[l];
                        if(sum==target){
                            List<Integer>tmp= Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                            Collections.sort(tmp);
                            ans.add(tmp);
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    static void funBetter(int[] arr,int n,int target){
        HashSet<List<Integer>>ans=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                HashSet<Integer>st=new HashSet<>();
                for(int k=j+1;k<n;k++){
                    int sum=arr[i]+arr[j]+arr[k];
                    int fourth=target-sum;
                    if(st.contains(fourth)){
                        List<Integer>list=Arrays.asList(arr[i],arr[j],arr[k],fourth);
                        Collections.sort(list);
                        ans.add(list);
                    }
                    st.add(arr[k]);
                }
            }
        }
        System.out.println(ans);
    }

    static void funOptimal(int[] arr,int n,int target){
        List<List<Integer>>ans=new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            if(i>0 && arr[i]==arr[i-1]){
                continue;
            }
            for(int j=i+1;j<n;j++){
                if(j!=(i+1)&&arr[j]==arr[j-1]){
                    continue;
                }
                int k=j+1;
                int l=n-1;
                while(k<l){
                    int sum=arr[i]+arr[j]+arr[k]+arr[l];
                    if(sum==target){
                        List<Integer>list=Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                        ans.add(list);
                        k++;
                        l--;
                        while(k<l && arr[k]==arr[k-1]){
                            k++;
                        }
                        while(k<l && arr[l]==arr[l+1]){
                            l--;
                        }
                    }else if(sum<target){
                        k++;
                    }else{
                        l--;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int[] arr={1,0,-1,0,-2,2};
        int n=arr.length;
        int target=0;

        //Brute : 4 loops
        funBrute(arr,n,target);
//        [[-2, 0, 0, 2], [-1, 0, 0, 1], [-2, -1, 1, 2]]

        // Better : 3 loops + Hashing
        funBetter(arr,n,target);
//        [[-2, 0, 0, 2], [-1, 0, 0, 1], [-2, -1, 1, 2]]

        //Optimal : sort+2 pointer
        funOptimal(arr,n,target);
//[[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
    }


}
