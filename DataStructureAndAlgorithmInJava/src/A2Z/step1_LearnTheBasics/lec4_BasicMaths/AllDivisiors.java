package A2Z.step1_LearnTheBasics.lec4_BasicMaths;

/*
Given an integer N, return all divisors of N.

A divisor of an integer N is a positive integer that divides N without leaving a remainder.

Example 1:
Input:N = 36

Output:[1, 2, 3, 4, 6, 9, 12, 18, 36]

Explanation: The divisors of 36 are 1, 2, 3, 4, 6, 9, 12, 18, 36.



*/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AllDivisiors {
    static void fun(int n){
        for(int i=1;i<=n;i++){
            if(n%i==0){
                System.out.print(i+" ");
            }
        }
    }

    static void fun1(int n){
        List<Integer>list=new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            if(n/i==i){
                list.add(i);
            }else if(n%i==0){
                list.add(i);
                list.add(n/i);
            }

        }
        Collections.sort(list);
        System.out.println(list);
    }

    public static void main(String[] args) {
        int n=36;
        fun(n);
        //1 2 3 4 6 9 12 18 36
        fun1(n);
    }
}
