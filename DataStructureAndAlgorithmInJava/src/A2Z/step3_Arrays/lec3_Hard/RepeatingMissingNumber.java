package A2Z.step3_Arrays.lec3_Hard;
/*
You are given a read-only array of N integers with values also in the range [1, N] both inclusive. Each integer appears exactly once except A which appears twice and B which is missing. The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.

Examples

Example 1:
Input Format:  array[] = {3,1,2,5,3}
Result: {3,4)
Explanation: A = 3 , B = 4
Since 3 is appearing twice and 4 is missing




*/

public class RepeatingMissingNumber {

    public static void funBrute(int[] arr,int n){
        int rep=-1;
        int mis=-1;
        for(int i=1;i<=n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(i==arr[j]){
                    cnt++;
                }
            }
            if(cnt==2){
                rep=i;
            }
            if(cnt==0){
                mis=i;
            }
            if(rep!=-1 && mis!=-1){
                break;
            }
        }
        System.out.println(rep+" "+mis);
    }

    public static void funBetter(int[] arr,int n){
        int[] hash=new int[n+1];
        for(int x:arr){
            hash[x]++;
        }
        int rep=-1;
        int mis=-1;
        for(int i=1;i<=n;i++){
            if(hash[i]==2){
                rep=i;
            }else if(hash[i]==0){
                mis=i;
            }
            if(rep!=-1 && mis!=-1){
                break;
            }
        }
        System.out.println(rep+" "+mis);
    }

    public static void funOptimal(int[] arr,int n){
        int sn=(n*(n+1))/2;
        int s2n=(n*(n+1)*(2*n+1))/6;
        int s=0;
        int s2=0;
        for(int i=0;i<n;i++){
            s=s+arr[i];
            s2=s2+(arr[i]*arr[i]);
        }
        int v1=s-sn;
        int v2=s2-s2n;
        v2=v2/v1;
        int x=(v1+v2)/2;
        int y=x-v1;
        System.out.println(x+" "+y);
    }

    public static void funOptimalXOR(int[] arr,int n){
        int xr=0;
        for(int i=0;i<n;i++){
            xr=xr^arr[i];
            xr=xr^(i+1);
        }
        int bitNo=0;
        while(true){
            if((xr&(1<<bitNo))!=0){
                break;
            }
            bitNo++;
        }
        int zero=0;
        int one=0;
        for(int i=0;i<n;i++){
            if((arr[i]&(1<<bitNo))!=0){
                one=one^arr[i];
            }else{
                zero=zero^arr[i];
            }
        }
        for(int i=1;i<=n;i++){
            if((i&(1<<bitNo))!=0){
                one=one^i;
            }else{
                zero=zero^i;
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(arr[i]==zero){
                cnt++;
            }
        }
        if(cnt==2){
            System.out.println(zero+" "+one);
            return;
        }
        System.out.println(one+" "+zero);
    }

    public static void main(String[] args) {
        int[] arr={3,1,2,5,3};
        int n=arr.length;

        //BruteForce: O(n^2)
        funBrute(arr,n);
        //3,4

        //Better: Hashing : O(n);
        funBetter(arr,n);

        //Optimal: Maths Solution O(n)
        funOptimal(arr,n);

        //Optimal: XOR Solution O(n)
        funOptimalXOR(arr,n);
    }
}
