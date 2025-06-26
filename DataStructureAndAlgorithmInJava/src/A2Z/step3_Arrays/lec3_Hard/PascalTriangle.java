package A2Z.step3_Arrays.lec3_Hard;

import java.util.ArrayList;
import java.util.List;
/*
Example 1:
Input Format: N = 5, r = 5, c = 3
Result: 6 (for variation 1)
1 4 6 4 1 (for variation 2)

1
1 1
1 2 1
1 3 3 1
1 4 6 4 1    (for variation 3)

In Pascal’s triangle, each number is the sum of the two numbers directly above it


*/

public class PascalTriangle {
    static int funNcR(int r,int c){
        int res=1;
        for(int i=0;i<c;i++){
            res=res*(r-i);
            res=res/(i+1);
        }
        return res;
    }

    static List<Integer> funNthRow(int n){
        List<Integer>list=new ArrayList<>();
        list.add(1);
        int ans=1;
        for(int i=1;i<n;i++){
            ans=ans*(n-i);
            ans=ans/i;
            list.add(ans);
        }
        return list;
    }

    static List<List<Integer>> funEntirePascal(int n){
        List<List<Integer>>list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            List<Integer>tmp=new ArrayList<>();
            int ans=1;
            tmp.add(1);
            for(int col=1;col<i;col++){
                ans=ans*(i-col);
                ans=ans/col;
                tmp.add(ans);
            }
            list.add(tmp);
        }
        return list;
    }
    public static void main(String[] args) {
        //Variation 1: Given row number r and column number c. Print the element at position (r, c) in Pascal’s triangle.
        int r=5;
        int c=3;
        int ans1=funNcR(r-1,c-1);
        System.out.println(ans1);
        //6

//        Variation 2: Given the row number n. Print the n-th row of Pascal’s triangle.

        int n=5;
        List<Integer>ans2=funNthRow(n);
        System.out.println(ans2);
        //[1, 4, 6, 4, 1]

//        Variation 3: Given the number of rows n. Print the first n rows of Pascal’s triangle.
        List<List<Integer>>ans3=funEntirePascal(n);
        System.out.println(ans3);
//[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]

    }
}
