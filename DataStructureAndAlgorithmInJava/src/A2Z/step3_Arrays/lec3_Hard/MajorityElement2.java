package A2Z.step3_Arrays.lec3_Hard;

/*
Given an array of N integers. Find the elements that appear more than N/3 times in the array. If no such element exists, return an empty vector.

Pre-requisite: Majority Element(>N/2 times)

Examples

Example 1:
Input Format: N = 5, array[] = {1,2,2,3,2}
Result: 2
Explanation: Here we can see that the Count(1) = 1, Count(2) = 3 and Count(3) = 1.Therefore, the count of 2 is greater than N/3 times. Hence, 2 is the answer.



*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElement2 {

    static List<Integer> funBetter(int[] arr, int n){
        List<Integer>ans=new ArrayList<>();
        HashMap<Integer,Integer>mp=new HashMap();
        int mini=(int)(n/3)+1;
        for(int i=0;i<n;i++){
            if(mp.containsKey(arr[i])){
                mp.put(arr[i],mp.get(arr[i])+1);
            }else {
                mp.put(arr[i],1);
            }
            if(mp.get(arr[i])==mini){
                ans.add(arr[i]);
            }
            if(ans.size()==2){
                break;
            }
        }
        return ans;

    }

    static List<Integer> funOptimal(int[] arr,int n){
        int cnt1=0;
        int cnt2=0;
        int el1=0;
        int el2=0;
        for(int i=0;i<n;i++){
            if(cnt1==0&&el2!=arr[i]){
                cnt1=1;
                el1=arr[i];
            }else if(cnt2==0&&el1!=arr[i]){
                cnt2=1;
                el2=arr[i];
            }else if(arr[i]==el1){
                cnt1++;
            }else if(arr[i]==el2){
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }

        List<Integer>ans=new ArrayList<>();
        cnt1=0;
        cnt2=0;
        for(int i=0;i<n;i++){
            if(el1==arr[i]){
                cnt1++;
            }
            if(el2==arr[i]){
                cnt2++;
            }
        }

        int mini=(int)(n/3)+1;
        if(cnt1>=mini){
            ans.add(el1);
        }
        if(cnt2>=mini){
            ans.add(el2);
        }

        return ans;

    }

    public static void main(String[] args) {
        int[] arr={1,2,2,3,2};
        int n=arr.length;

        List<Integer> ans1=funBetter(arr,n);
        System.out.println(ans1);

        List<Integer> ans2=funOptimal(arr,n);
        System.out.println(ans2);

    }
}
