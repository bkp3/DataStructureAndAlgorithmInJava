package A2Z.step3_Arrays.lec2_Medium;

/*
 Given an array of N integers, write a program to return an element that occurs more than N/2 times in the given array. You may consider that such an element always exists in the array.

Examples

Example 1:
Input Format: N = 3, nums[] = {3,2,3}
Result: 3
Explanation: When we just count the occurrences of each number and compare with half of the size of the array, you will get 3 for the above solution.



*/

public class MajorityElement {
    public static void main(String[] args) {
        // brute : two for loops
        // better : hashing using hashmap
        // optimal : Moore's voting algorithm

        int[] arr={4,4,2,4,3,4,4,3,2,4};
        int n=arr.length;
        int cnt=0;
        int el=0;
        for(int x:arr){
            if(cnt==0){
                cnt=1;
                el=x;
            }else if(el==x){
                cnt++;
            }else{
                cnt--;
            }
        }
        int cnt1=0;
        for(int x:arr){
            if(x==el){
                cnt1++;
            }
        }
        if(cnt1 > n/2){
            System.out.println(el);
            //4
        }else {
            System.out.println("Not any element is majority");
        }

    }
}
