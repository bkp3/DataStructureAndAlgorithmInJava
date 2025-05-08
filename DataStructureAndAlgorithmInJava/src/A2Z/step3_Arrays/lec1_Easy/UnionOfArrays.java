package A2Z.step3_Arrays.lec1_Easy;

import java.util.ArrayList;
import java.util.List;

/*
Given two sorted arrays, arr1, and arr2 of size n and m. Find the union of two sorted arrays.

The union of two arrays can be defined as the common and distinct elements in the two arrays.NOTE: Elements in the union should be in ascending order.

Examples

Example 1:
Input:
n = 5,m = 5.
arr1[] = {1,2,3,4,5}
arr2[] = {2,3,4,4,5}
Output:
 {1,2,3,4,5}



*/

public class UnionOfArrays {
    public static void main(String[] args) {
        int[] a1={1,1,2,3,4,5};
        int[] a2={2,3,4,4,5,6};
        int n1=a1.length;
        int n2=a2.length;

        //Brute Force : Using HashSet ( Store elements of both the arrays in HashSet)

        List<Integer>list=new ArrayList<>();
        int i=0;
        int j=0;
        int k=0;
        if(a1[i]<=a2[j]){
            list.add(a1[i]);
            i++;
        }else{
            list.add(a2[j]);
            j++;
        }
        while(i<n1&&j<n2){
            if(a1[i]<=a2[j]){
                if(list.size()==0 || list.get(k)!=a1[i]){
                    list.add(a1[i]);
                    k++;
                }
                i++;
            }else {
                if(list.size()==0 || list.get(k)!=a2[j]){
                    list.add(a2[j]);
                    k++;
                }
                j++;
            }
        }

        while (i<n1){
            if(list.size()==0 || list.get(k)!=a1[i]){
                list.add(a1[i]);
                k++;
            }
            i++;
        }

        while (j<n2){
            if(list.size()==0 || list.get(k)!=a2[j]){
                list.add(a2[j]);
                k++;
            }
            j++;
        }
        System.out.println(list);
//[1, 2, 3, 4, 5, 6]

    }
}
